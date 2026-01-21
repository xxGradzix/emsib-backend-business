package com.emsib.emsib_backend_business;

import com.emsib.emsib_backend_business.relational_database.BuildingEnt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication

@EnableJpaRepositories(basePackages = {"com.emsib.emsib_backend_business.relational_database","com.emsib.emsib_backend_business.logic.repository" })


@EntityScan(basePackages = "com.emsib.emsib_backend_business.relational_database")
public class EmsibBackendBusinessApplication {

	public static void main(String[] args) {
        //TESTING ONLY - DO USE DAOs with try-with-resource
        // eg. tutorial: https://www.javaguides.net/2018/12/hibernate-transaction-management-tutorial.html

     //   SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
      //  Session session = factory.openSession();
     //   Transaction tx = session.beginTransaction();

        //inserting
//        UserEnt user = new UserEnt();
//        user.name = "John";
//        user.surname = "Janus";
//        user.email = "john.jan@example.com";
//        user.phone = "123436789";
//        user.nip = null;
//        user.passwordHash = new byte[] {0x45, 0x21};
//        user.salt = new byte[] {0x25};
//
//        session.persist(user);   // or session.save(user)

        //inserting 2
//        BuildingEnt b = new BuildingEnt();
//        b.name = "Cotton Apts.";
//        b.street = "Narutowicza";
//        b.streetNum = "3c";
//        b.postalCode = "12-345";
//        b.city = "Warsaw";
//        b.numOfFloors = 52;
//        session.persist(b);

        //inserting 3
//        UserBuildingEnt ubEnt = new UserBuildingEnt();
//        ubEnt.userId = 2;
//        ubEnt.buildingId = 1;
//        ubEnt.ubRoleId = 3;
//
//        session.persist(ubEnt);

        //inserting 4
//        DeviceEnt devEnt = new DeviceEnt();
//        devEnt.manufacturer = "Amica";
//        devEnt.model = "FK3606D.2DFWi (E)";
//        devEnt.isPrivate = true; //for personal appliances
//        devEnt.deviceStatusId = 1;
//        devEnt.currentPowerTarget = 30f;
//        devEnt.maxPowerConsumption = 50f;
//
//        session.persist(devEnt);

        //inserting 5
//        DeviceEnt devEnt = new DeviceEnt();
//        devEnt.manufacturer = "TwojDzwig";
//        devEnt.model = "amb-12345";
//        devEnt.description = "elevator 1";
//        devEnt.isPrivate = false; //for public services
//        devEnt.deviceStatusId = 2;
//        devEnt.currentPowerTarget = 0f;
//        devEnt.maxPowerConsumption = 5000f;
//
//        session.persist(devEnt);

        //inserting 6
//        BuildingDeviceEnt bdEnt = new BuildingDeviceEnt();
//        bdEnt.buildingId = 1;
//        bdEnt.deviceId = 2;
//
//        session.persist(bdEnt);

        //ins 7
//        UserPropertyEnt ent = new UserPropertyEnt();
//        ent.userId = 1;
//        ent.propertyId = 1;
//
//        session.persist(ent);

        //ins 8
//        PropertyEnt ent = new PropertyEnt();
//        ent.name = "Office 1";
//        ent.floor = 3;
//        ent.propertyTypeId = 1;
//        ent.buildingId = 1;
//
//        session.persist(ent);

        //ins 9
//        PropertyDeviceEnt ent = new PropertyDeviceEnt();
//        ent.propertyId = 1;
//        ent.deviceId = 1;
//
//        session.persist(ent);

        //select of single table
//        List<BuildingEnt> lst = session.createQuery("from BuildingEnt", BuildingEnt.class).list();
//        for (BuildingEnt el : lst) {
//            System.out.println(el);
//        }

        //joins 1
//        String hql = "SELECT p, pt, b FROM PropertyEnt p JOIN p.propertyType pt JOIN p.building b";
//
//        List<Object[]> lst = session.createQuery(hql, Object[].class).list();
//        for (Object[] el : lst) {
//            System.out.println(el[0] + " " + el[1] + " " + el[2]);
//        }

        //joins 2
//        String hql = "SELECT up, u, p FROM UserPropertyEnt up JOIN up.user u JOIN up.property p ";
//
//        List<Object[]> lst = session.createQuery(hql, Object[].class).list();
//        for (Object[] el : lst) {
//            System.out.println(el[0] + " " + el[1] + " " + el[2]);
//        }

        //joins 3
       // String hql = "SELECT ub, ubr, u, b FROM UserBuildingEnt ub JOIN ub.role ubr JOIN ub.user u JOIN ub.building b";
        //         String hql = "SELECT ub, ubr, u, b FROM UserBuildingEnt ub JOIN ub.role ubr JOIN ub.user u JOIN ub.building b";

        //         List<Object[]> lst = session.createQuery(hql, Object[].class).list();
        //         for (Object[] el : lst) {
        //                 System.out.println(el[0] + " " + el[1] + " " + el[2] + " " + el[3]);
        // }
        // } catch (Exception e) {
        //         System.err.println(e);
        // }
        
       // List<Object[]> lst = session.createQuery(hql, Object[].class).list();
       // for (Object[] el : lst) {
       //     System.out.println(el[0] + " " + el[1] + " " + el[2] + " " + el[3]);
       // }

        //joins 4
//        String hql = "SELECT pd, p, d FROM PropertyDeviceEnt pd JOIN pd.property p JOIN pd.device d";
//
//        List<Object[]> lst = session.createQuery(hql, Object[].class).list();
//        for (Object[] el : lst) {
//            System.out.println(el[0] + " " + el[1] + " " + el[2]);
//        }

        //joins 5
//        String hql = "SELECT bd, b, d FROM BuildingDeviceEnt bd JOIN bd.building b JOIN bd.device d";
//
//        List<Object[]> lst = session.createQuery(hql, Object[].class).list();
//        for (Object[] el : lst) {
//            System.out.println(el[0] + " " + el[1] + " " + el[2]);
//        }

        //joins 6 - 2 ent
//        String hql = "SELECT d, ds FROM DeviceEnt d JOIN d.deviceStatus ds ";
//
//        List<Object[]> lst = session.createQuery(hql, Object[].class).list();
//        for (Object[] el : lst) {
//            System.out.println(el[0] + " " + el[1]);
//        }

       // tx.commit();
       // session.close();
       // factory.close();

        //TESTING ONLY


		SpringApplication.run(EmsibBackendBusinessApplication.class, args);
	}

}
