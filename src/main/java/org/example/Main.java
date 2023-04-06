package org.example;

import java.util.ArrayList;
import java.util.HashMap;

class cars{
    static String Hatchback="hatchback";
    static String Sedan="sedan";
    static String Suv="suv";
}
class garage{
    HashMap<String,Service> typeservice= new HashMap<String,Service>();
    garage(){
        typeservice.put("BS01",new Service("BS01","Basic Service",2000,4000,5000));
        typeservice.put("EF01",new Service("EF01","Engine Service",5000,8000,10000));
        typeservice.put("CF01",new Service("CF01","Clutch Fixing",2000,4000,6000));
        typeservice.put("BF01",new Service("BF01","Brake Fixing",1000,1500,2500));
        typeservice.put("GF01",new Service("BS01","Gear Fixing",3000,6000,8000));
    }
    int totalamount=0;
    void Bill(String Cartype,ArrayList<String>servicecodes){
        for(String servicecode:servicecodes){
            Service a= this.typeservice.get(servicecode);
            int Price= a.rupees(Cartype);
            totalamount=totalamount+Price;
            System.out.println("Charges for "+a.servicename+"- RS"+Price);
        }
        System.out.println("Total Bill: RS"+totalamount);
        if(totalamount>10000){
            System.out.println("Free complimentary cleaning will be provided..");
        }
    }
}
class Service{
    String servicename;
    String servicecode;
    HashMap<String,Integer> price= new HashMap<String,Integer>();
    Service(String servicename,String servicecode,int Hatchbackcharge, int Sedancharge, int Suvcharge){
        this.servicename= servicename;
        this.servicecode= servicecode;
        price.put(cars.Hatchback,Hatchbackcharge);
        price.put(cars.Sedan,Sedancharge);
        price.put(cars.Suv,Suvcharge);
    }
    public int rupees(String cartype){
        return price.get(cartype);
    }
}
public class Main {
        public static void main(String[] args){
            garage obj= new garage();
            ArrayList<String> str= new ArrayList<String>();
            str.add("BS01");
            str.add("EF01");
            obj.Bill(cars.Hatchback,str);
    }
}