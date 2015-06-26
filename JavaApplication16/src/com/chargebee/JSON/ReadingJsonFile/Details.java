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

/**
 *
 * @author cb-aashiek
 */
public class Details {
    
    public void processor(JSONObject jobj, Student student, Teacher teacher) throws JSONException {

        student.setJoiningDate(jobj.getJSONObject("Student").getString("Date Of Joining"));
        student.setId(jobj.getJSONObject("Student").getString("ID"));
        student.setName(jobj.getJSONObject("Student").getString("Name"));
        student.setStandard(jobj.getJSONObject("Student").getString("Std"));

        String[] tempo1 = new String[5];
        String[] tempo2 = new String[5];

        JSONArray arrayStudent = jobj.getJSONObject("Student").getJSONArray("Marks");
        for (int i = 0; i < arrayStudent.length(); i++) {
            tempo1[i] = arrayStudent.getJSONObject(i).getString("Mark");
            tempo2[i] = arrayStudent.getJSONObject(i).getString("Subject");
        }
        student.setMarks(tempo1);
        student.setSubject(tempo2);
        
        teacher.setId(jobj.getJSONObject("Teacher").getString("ID"));
        teacher.setName(jobj.getJSONObject("Teacher").getString("Name"));
        teacher.setSalary(jobj.getJSONObject("Teacher").getString("Salary"));
        teacher.setJoiningDate(jobj.getJSONObject("Teacher").getString("Date Of Joining"));

        JSONArray arrayTeacher = jobj.getJSONObject("Teacher").getJSONArray("Classes Taking Care Of");
        String[] tempo3 = new String[3];
        for (int i = 0; i < arrayTeacher.length(); i++) {
            tempo3[i] = arrayTeacher.getString(i);
        }
        teacher.setClassesHandled(tempo3);
    }

    public static void main(String[] args) throws Exception {
        String source = System.getProperty("user.home") + "/input.json";

        Details d = new Details();
        Student s = new Student();
        Teacher t = new Teacher();

        JSONObject jobj = readJsonObjectData(source);
        d.processor(jobj, s, t);
        s.print();
        System.out.println();
        t.print();
    }
}
