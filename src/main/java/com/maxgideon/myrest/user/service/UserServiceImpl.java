package com.maxgideon.myrest.user.service;

import com.maxgideon.myrest.office.dao.OfficeDao;
import com.maxgideon.myrest.office.entity.Office;
import com.maxgideon.myrest.user.dao.UserDao;
import com.maxgideon.myrest.user.entity.Documents;
import com.maxgideon.myrest.user.entity.User;
import com.maxgideon.myrest.references.entity.Countries;
import com.maxgideon.myrest.references.entity.DocumentsType;
import com.maxgideon.myrest.user.service.data.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Autowired
    OfficeDao officeDao;

    public List<UserDto> getAllUser(UserDto userDto){
        List<User> list = userDao.getAllUser(userDto);
        List<UserDto> listDto = new ArrayList<>();
        for(User us: list){
            listDto.add(new UserDto(us.getId(),us.getFirstName(),us.getSecondName(),us.getMiddleName(),us.getPosition()));
        }
        return listDto;
    };


    public UserDto getUserById(long id){
          User user = userDao.getUserById(id);
          UserDto userDto = new UserDto(user);
          return userDto;
    };

    @Transactional
    public void saveUser(UserDto userDto){
        User user = new User();
        userUpdate(userDto,user);
        Documents documents = null;
        Countries countries = null;
        if (userDto.getDocCode() != null || userDto.getDocName() != null) {
            documents = addDocumentType(userDto,documents);
        }
        if (userDto.getDocDate() != null || userDto.getDocNumber() != null) {
            if (documents != null) {
                documents.setDocDate(userDto.getDocDate());
                documents.setDocNumber(userDto.getDocNumber());
            }else {
                documents = new Documents();
                documents.setDocDate(userDto.getDocDate());
                documents.setDocNumber(userDto.getDocNumber());
            }
        }
        if (userDto.getCitizenshipCode() != null) {
            countries = userDao.getCountriesByCitizenshipCode(userDto.getCitizenshipCode());
            user.setCountries(countries);
        }
        if(documents != null){
            user.setDocuments(documents);
        }
        Office office = officeDao.getOfficeById(userDto.getOfficeId());
        user.setOffice(office);

        userDao.saveUser(user);

    };

    @Transactional
    public void updateUser(UserDto userDto){
        User user = userDao.getUserById(userDto.getId());
        userUpdate(userDto,user);
        Documents documents = user.getDocuments();
        if(userDto.getOfficeId() != null){
            Office office = officeDao.getOfficeById(userDto.getOfficeId());
            user.setOffice(office);
        }
        if(userDto.getDocNumber() != null){
            if(documents != null){
                documents.setDocNumber(userDto.getDocNumber());
            }else{
                documents = new Documents();
                documents.setDocNumber(userDto.getDocNumber());
                user.setDocuments(documents);
            }
        }
        if(userDto.getDocDate() != null){
            if(documents != null){
                documents.setDocDate(userDto.getDocDate());
            }else{
                documents = new Documents();
                documents.setDocDate(userDto.getDocDate());
                user.setDocuments(documents);
            }
        }
        if(userDto.getCitizenshipCode() != null){
            Countries countries = userDao.getCountriesByCitizenshipCode(userDto.getCitizenshipCode());
            user.setCountries(countries);
        }
        if(userDto.getDocName() != null){
            documents = addDocumentType(userDto, documents);
            user.setDocuments(documents);
        }

    };


    /**
     * ?????????? ?????? ???????????????????? ?????????????? ?????????????? User ???????????????????? ?????????????? UserDto
     * @param user ???????????? ???????????? User
     */
    private void userUpdate(UserDto userDto, User user){
        user.setFirstName(userDto.getFirstName());
        if(userDto.getSecondName() != null) {
            user.setSecondName(userDto.getSecondName());
        }
        if(userDto.getMiddleName() != null) {
            user.setMiddleName(userDto.getMiddleName());
        }

        user.setPosition(userDto.getPosition());

        if(userDto.getPhone() != null) {
            user.setPhone(userDto.getPhone());
        }
        if(userDto.getIsIdentified() != null) {
            user.setIsIdentified(userDto.getIsIdentified());
        }
    }

    /**
     * ?????????? ?????? ???????????????????? DocumentsType ?? Documents
     * @param userDto ?????????? ???????????? UserDto
     * @param documents ???????????? ???????????? Documents
     * @return
     */
    private Documents addDocumentType(UserDto userDto, Documents documents){
        DocumentsType documentsType = userDao.getDocumentsTypeByCodeOrName(userDto.getDocCode(), userDto.getDocName());

        if(documents != null){
            documents.setDocType(documentsType);
        }else {
            documents = new Documents();
            documents.setDocType(documentsType);
        }
        return documents;
    }
}
