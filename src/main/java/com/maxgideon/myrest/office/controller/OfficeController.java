package com.maxgideon.myrest.office.controller;

import com.maxgideon.myrest.office.service.OfficeService;
import com.maxgideon.myrest.office.service.data.OfficeDto;
import com.maxgideon.myrest.validation.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@Validated
@RequestMapping(value = "api/office")
public class OfficeController {

    @Autowired
    OfficeService officeService;

    @Validated({Marker.ListObject.class})
    @PostMapping("/list")
    public List<OfficeDto> showAllOffice(@RequestBody @Valid OfficeDto officeDto){
        return officeService.getAllOffice(officeDto);
    }

    @GetMapping("/{id}")
    public OfficeDto getOfficeById(@PathVariable long id){
        return officeService.getOfficeById(id);
    }

    @Validated({Marker.SaveObject.class})
    @PostMapping("/save")
    public void saveOffice(@RequestBody @Valid OfficeDto officeDto){
        officeService.saveOffice(officeDto);
    }

    @Validated({Marker.UpdateObject.class})
    @PostMapping("/update")
    public void updateOffice(@RequestBody @Valid OfficeDto officeDto){
        officeService.updateOffice(officeDto);
    }

}
