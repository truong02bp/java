package com.mypham.Utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MessengeUtil
{
    public String getMessenge(String name)
    {
        Map<String,String> map = new HashMap<>();
        map.put("success_insert","Thêm thành công");
        map.put("success_update","Cập nhật thành công");
        map.put("error_insert","Thêm thất bại");
        map.put("error_update","Cập nhật thất bại");
        map.put("success_delete","Xóa thành công");
        map.put("error_delete","Xóa thất bại");
        return map.get(name);
    }
    public String getAlert(String name)
    {
        Map<String, String> map = new HashMap<>();
        map.put("success_insert", "success");
        map.put("success_update", "success");
        map.put("error_insert", "danger");
        map.put("error_update", "danger");
        map.put("success_delete","success");
        map.put("error_delete","danger");
        return map.get(name);
    }
}
