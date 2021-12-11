package com.maxgideon.myrest.office.controller;

import com.maxgideon.myrest.exception.ResponseResult;
import com.maxgideon.myrest.office.service.OfficeService;
import com.maxgideon.myrest.office.service.data.OfficeDto;
import com.maxgideon.myrest.validation.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("api/office")
public class OfficeController {

    @Autowired
    OfficeService officeService;

    @Validated({Marker.ListObject.class})
    @PostMapping("/list")
    public Object showAllOffice(@RequestBody @Valid OfficeDto officeDto){
        return officeService.getAllOffice(officeDto);
    }

    @GetMapping("/{id}")
    public Object getOfficeById(@PathVariable long id){
        return officeService.getOfficeById(id);
    }

    @Validated({Marker.SaveObject.class})
    @PostMapping("/save")
    public ResponseEntity<ResponseResult> saveOffice(@RequestBody @Valid OfficeDto officeDto){
        officeService.saveOffice(officeDto);
        return new ResponseEntity<>(new ResponseResult("success"), HttpStatus.OK);
    }

    @Validated({Marker.UpdateObject.class})
    @PostMapping("/update")
    public ResponseEntity<ResponseResult> updateOffice(@RequestBody @Valid OfficeDto officeDto){
        officeService.updateOffice(officeDto);
        return new ResponseEntity<>(new ResponseResult("success"), HttpStatus.OK);
    }

}
