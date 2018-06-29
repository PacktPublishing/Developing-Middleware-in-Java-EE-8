/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mavenproject6;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

/**
 *
 * @author abdalla
 */
public class Ex9 {

    public static void main(String[] args) throws ParseException {
JsonbConfig config = new JsonbConfig().withFormatting(true).withDateFormat("dd/MM/yyyy", Locale.getDefault());
Jsonb jsonb = JsonbBuilder.create(config);

SimpleDateFormat sdfDate = new SimpleDateFormat("MM/dd/yyyy");
SimpleDateFormat sdfTime = new SimpleDateFormat("MM/dd/yyyy hh:mm a");

User user = new User();
user.setId(5);
user.setName("Abdalla Mahmoud");
user.setBirthDate(sdfDate.parse("07/06/1988"));
user.setLastLoggedIn(sdfTime.parse("10/06/2017 03:20 pm"));
user.setAverageLoggedInTime(new BigDecimal("3.1562"));

String json = jsonb.toJson(user);
System.out.println(json);

    }
}
