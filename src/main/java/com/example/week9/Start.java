package com.example.week9;

import com.example.week9.aspect.TimerAspect;
import com.example.week9.model.RandomUserMongoDb;
import com.example.week9.model.RandomUserMysqlDb;
import com.example.week9.mongoDb.service.UserServiceMongoDb;
import com.example.week9.mysqlDb.service.UserServiceMysqlDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Scanner;

@Component
public class Start {

    private UserServiceMongoDb userServiceMongoDb;
    private UserServiceMysqlDb userServiceMysqlDb;
    private TimerAspect timerAspect;

    @Autowired
    public Start(UserServiceMongoDb userServiceMongoDb, UserServiceMysqlDb userServiceMysqlDb,
                 TimerAspect timerAspect) {
        this.userServiceMongoDb = userServiceMongoDb;
        this.userServiceMysqlDb = userServiceMysqlDb;
        this.timerAspect = timerAspect;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initialize() {
        saveDataMongoDb();
        System.out.println("Time save in mongoDb - " + timerAspect.getResultTime());
        saveDataMysqlDb();
        System.out.println("Time save in MySql - " +timerAspect.getResultTime());
        readDataMongoDb();
        System.out.println("Time read data in mongoDb - " +timerAspect.getResultTime());
        readDataMysqlDb();
        System.out.println("Time read data in MySql - " +timerAspect.getResultTime());
    }


    private void saveDataMongoDb() {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/MOCK_DATA.csv"));
            while (scanner.hasNext()) {
                String[] elem = scanner.next().split(",");
                userServiceMongoDb.saveUser(new RandomUserMongoDb(elem[0], elem[1], elem[2], elem[3], elem[4], elem[5]));
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveDataMysqlDb() {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/MOCK_DATA.csv"));
            while (scanner.hasNext()) {
                String[] elem = scanner.next().split(",");
                Long id = Long.valueOf(elem[0]);
                userServiceMysqlDb.saveUser(new RandomUserMysqlDb(id, elem[1], elem[2], elem[3], elem[4], elem[5]));
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readDataMongoDb() {
        userServiceMongoDb.getAllUsers();
    }

    private void readDataMysqlDb() {
        userServiceMysqlDb.getAllUsers();
    }
}
