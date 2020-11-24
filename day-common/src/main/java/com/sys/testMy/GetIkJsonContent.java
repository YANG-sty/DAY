package com.sys.testMy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

/**
 * Create by yang_zzu on 2020/11/16 on 16:40
 */
public class GetIkJsonContent {

    @Data
    static class Content {
        private Integer end_offset;
        private Integer position;
        private Integer start_offset;
        private String token;
        private String type;
    }

    @Test
    public void test1() {

        String string = "{\n" +
                "\"tokens\": [ { \"token\": \"中华人民共和国\",\"start_offset\": 0,\"end_offset\": 7,\"type\": \"CN_WORD\",\"position\": 0},{ \"token\": \"中华人民\",\"start_offset\": 0,\"end_offset\": 4,\"type\": \"CN_WORD\",\"position\": 1},{ \"token\": \"中华\",\"start_offset\": 0,\"end_offset\": 2,\"type\": \"CN_WORD\",\"position\": 2},{ \"token\": \"华人\",\"start_offset\": 1,\"end_offset\": 3,\"type\": \"CN_WORD\",\"position\": 3},{ \"token\": \"人民共和国\",\"start_offset\": 2,\"end_offset\": 7,\"type\": \"CN_WORD\",\"position\": 4},{ \"token\": \"人民\",\"start_offset\": 2,\"end_offset\": 4,\"type\": \"CN_WORD\",\"position\": 5},{ \"token\": \"共和国\",\"start_offset\": 4,\"end_offset\": 7,\"type\": \"CN_WORD\",\"position\": 6},{ \"token\": \"共和\",\"start_offset\": 4,\"end_offset\": 6,\"type\": \"CN_WORD\",\"position\": 7},{ \"token\": \"国\",\"start_offset\": 6,\"end_offset\": 7,\"type\": \"CN_CHAR\",\"position\": 8},{ \"token\": \"国歌\",\"start_offset\": 7,\"end_offset\": 9,\"type\": \"CN_WORD\",\"position\": 9}]\n" +
                "}\n";

        JSONObject jsonObject = JSONObject.parseObject(string);
        Object tokens = jsonObject.get("tokens");
        JSONArray jsonArray = (JSONArray) tokens;

        List<Content> contents = JSONArray.parseArray(String.valueOf(jsonArray), Content.class);
        contents.forEach(content -> {
            System.out.println(content.getToken());
        });

    }


    @Test
    public void test2() {

        String string = "{\n" +
                "\"tokens\": [ { \"token\": \"中华人民共和国\",\"start_offset\": 0,\"end_offset\": 7,\"type\": \"CN_WORD\",\"position\": 0},{ \"token\": \"中华人民\",\"start_offset\": 0,\"end_offset\": 4,\"type\": \"CN_WORD\",\"position\": 1},{ \"token\": \"中华\",\"start_offset\": 0,\"end_offset\": 2,\"type\": \"CN_WORD\",\"position\": 2},{ \"token\": \"华人\",\"start_offset\": 1,\"end_offset\": 3,\"type\": \"CN_WORD\",\"position\": 3},{ \"token\": \"人民共和国\",\"start_offset\": 2,\"end_offset\": 7,\"type\": \"CN_WORD\",\"position\": 4},{ \"token\": \"人民\",\"start_offset\": 2,\"end_offset\": 4,\"type\": \"CN_WORD\",\"position\": 5},{ \"token\": \"共和国\",\"start_offset\": 4,\"end_offset\": 7,\"type\": \"CN_WORD\",\"position\": 6},{ \"token\": \"共和\",\"start_offset\": 4,\"end_offset\": 6,\"type\": \"CN_WORD\",\"position\": 7},{ \"token\": \"国\",\"start_offset\": 6,\"end_offset\": 7,\"type\": \"CN_CHAR\",\"position\": 8},{ \"token\": \"国歌\",\"start_offset\": 7,\"end_offset\": 9,\"type\": \"CN_WORD\",\"position\": 9}]\n" +
                "}\n";

        JSONObject jsonObject = JSONObject.parseObject(string);
        Object tokens = jsonObject.get("tokens");
        JSONArray jsonArray = (JSONArray) tokens;

        for (Object o : jsonArray) {
            JSONObject object = (JSONObject) o;
            System.out.println(object.get("token"));
        }

    }


    @Test
    public void test3() {

        String string = "{\n" +
                "\"tokens\": [ { \"token\": \"中华人民共和国\",\"start_offset\": 0,\"end_offset\": 7,\"type\": \"CN_WORD\",\"position\": 0},{ \"token\": \"中华人民\",\"start_offset\": 0,\"end_offset\": 4,\"type\": \"CN_WORD\",\"position\": 1},{ \"token\": \"中华\",\"start_offset\": 0,\"end_offset\": 2,\"type\": \"CN_WORD\",\"position\": 2},{ \"token\": \"华人\",\"start_offset\": 1,\"end_offset\": 3,\"type\": \"CN_WORD\",\"position\": 3},{ \"token\": \"人民共和国\",\"start_offset\": 2,\"end_offset\": 7,\"type\": \"CN_WORD\",\"position\": 4},{ \"token\": \"人民\",\"start_offset\": 2,\"end_offset\": 4,\"type\": \"CN_WORD\",\"position\": 5},{ \"token\": \"共和国\",\"start_offset\": 4,\"end_offset\": 7,\"type\": \"CN_WORD\",\"position\": 6},{ \"token\": \"共和\",\"start_offset\": 4,\"end_offset\": 6,\"type\": \"CN_WORD\",\"position\": 7},{ \"token\": \"国\",\"start_offset\": 6,\"end_offset\": 7,\"type\": \"CN_CHAR\",\"position\": 8},{ \"token\": \"国歌\",\"start_offset\": 7,\"end_offset\": 9,\"type\": \"CN_WORD\",\"position\": 9}]\n" +
                "}\n";

        JSONObject jsonObject = JSONObject.parseObject(string);
        Object tokens = jsonObject.get("tokens");
        JSONArray jsonArray = (JSONArray) tokens;

        for (Object o : jsonArray) {
            Content content = JSONObject.parseObject(String.valueOf(o), Content.class);
            System.out.println(content.getToken());

        }

    }



}
