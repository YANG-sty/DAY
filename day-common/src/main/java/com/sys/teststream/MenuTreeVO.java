package com.sys.teststream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MenuTreeVO {
    //    private String code = null;
//    private Integer elementStatus = null;
//    private String description = null;
//    private String remark = null;
//    private Integer sort = null;
//    private Integer type = null;
//    private Long parentId = null;
//    private String idPath = null;
    private List<MenuTreeVO> children;
    private Long elementResourceId;
    private String name ;
    private String pathUrl;
//    private String iconUrl = null;
}
