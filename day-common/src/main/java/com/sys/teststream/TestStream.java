package com.sys.teststream;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yangLongFei 2021-01-18-11:53
 */
public class TestStream {

    /**
     * 嵌套
     * @return
     */
    public MenuTreeVO mock() {
        List<MenuTreeVO> menuTreeVOList = new ArrayList<>();
        List<MenuTreeVO> menuTreeVOList1 = new ArrayList<>();
        List<MenuTreeVO> menuTreeVOList2 = new ArrayList<>();
        List<MenuTreeVO> menuTreeVOList3 = new ArrayList<>();
        List<MenuTreeVO> menuTreeVOList4 = new ArrayList<>();
        List<MenuTreeVO> menuTreeVOList5 = new ArrayList<>();

        /**
         * List
         *      List1
         *          list4
         *      List2
         *          list5
         *      list3
         */
        MenuTreeVO menuTreeVO4_1 = new MenuTreeVO(new ArrayList<>(), 4L, "编辑", "www.编辑.com");
        MenuTreeVO menuTreeVO4_2 = new MenuTreeVO(new ArrayList<>(), 4L, "新增", "www.新增.com");
        MenuTreeVO menuTreeVO5_1 = new MenuTreeVO(new ArrayList<>(), 5L, "查询", "www.查询.com");
        MenuTreeVO menuTreeVO5_2 = new MenuTreeVO(new ArrayList<>(), 5L, "导入", "www.导入.com");
        menuTreeVOList5.add(menuTreeVO5_1);
        menuTreeVOList5.add(menuTreeVO5_2);
        menuTreeVOList4.add(menuTreeVO4_1);
        menuTreeVOList4.add(menuTreeVO4_2);

        MenuTreeVO menuTreeVO3_1 = new MenuTreeVO(new ArrayList<>(), 3L, "删除", "www.删除.com");
        menuTreeVOList3.add(menuTreeVO3_1);

        MenuTreeVO menuTreeVO1_1 = new MenuTreeVO(menuTreeVOList4, 1L, "公司信息", "www.公司信息.com");
        MenuTreeVO menuTreeVO1_2 = new MenuTreeVO(menuTreeVOList5, 1L, "发票地址", "www.发票地址.com");
        MenuTreeVO menuTreeVO1_3 = new MenuTreeVO(menuTreeVOList3, 1L, "收货地址", "www.收货地址.com");


        menuTreeVOList.add(menuTreeVO1_1);
        menuTreeVOList.add(menuTreeVO1_2);
        menuTreeVOList.add(menuTreeVO1_3);

        MenuTreeVO menuTreeVO = new MenuTreeVO(menuTreeVOList, 0L, "在线订货", "www.在线订货.com");

        return menuTreeVO;
    }

    @Test
    public void test1() {
        MenuTreeVO mock = mock();
        System.out.println(JSON.toJSON(mock));

        boolean b = mock.getName().equals("在线订货");
        if (b) {
            List<MenuTreeVO> children = mock.getChildren();
            List<MenuTreeVO> list2 = children.stream().filter(a -> a.getName().equals("公司信息")).collect(Collectors.toList());
            if (list2.size()>0) {
            }
            System.out.println(list2);
        }


    }
}
