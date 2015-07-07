/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chargebee.JSON.ReadingJsonFile;

import static com.chargebee.MethodBank.MethodBank.readJsonObjectData;
import com.chargebee.org.json.JSONArray;
import com.chargebee.org.json.JSONException;
import com.chargebee.org.json.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author cb-aashiek
 */
public class Details {

    public static void processor(JSONObject jobj) throws JSONException {
        Iterator iterator = jobj.keys();

        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (key.toLowerCase().equalsIgnoreCase("student")) {
                Student s = new Student();
                ArrayList<Marks> list = new ArrayList();
                s.setName(jobj.getJSONObject(key).getString("Name"));
                s.setId(jobj.getJSONObject(key).getString("ID"));
                s.setJoiningDate(jobj.getJSONObject(key).getString("Date Of Joining"));
                s.setStandard(jobj.getJSONObject(key).getString("Std"));
                JSONArray tempo = jobj.getJSONObject(key).getJSONArray("Marks");

                for (int i = 0; i < tempo.length(); i++) {
                    JSONObject tempoObj = tempo.getJSONObject(i);
                    list.add(new Marks(Float.parseFloat(tempoObj.getString("Mark")), tempoObj.getString("Subject")));
                }
                s.setMarks(list);
                s.print();
                System.out.println();
            } else if (key.toLowerCase().equalsIgnoreCase("teacher")) {
                Teacher t = new Teacher();
                ArrayList<String> list = new ArrayList();
                t.setName(jobj.getJSONObject(key).getString("Name"));
                t.setId(jobj.getJSONObject(key).getString("ID"));
                t.setJoiningDate(jobj.getJSONObject(key).getString("Date Of Joining"));
                t.setSalary(Float.parseFloat(jobj.getJSONObject(key).getString("Salary")));

                JSONArray tempo = jobj.getJSONObject(key).getJSONArray("Classes Taking Care Of");

                for (int i = 0; i < tempo.length(); i++) {
                    list.add(tempo.getString(i));
                }
                t.setClassesHandled(list);
                t.print();
                System.out.println();
            }
        }

    }

    public static void main(String[] args) throws Exception {
        String source = System.getProperty("user.home") + "/input.json";

        JSONObject jobj = readJsonObjectData(source);
        processor(jobj);
    }
}
