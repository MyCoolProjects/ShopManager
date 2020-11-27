package com.example.demo;

import com.example.entity.*;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
@Profile("demo")
public class DemoMode {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    Specification_nameRepository specification_nameRepository;

    @Autowired
    Specification_valueRepository specification_valueRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadImage() throws IOException {

        //Категории
        Category category1 = new Category("Смартфоны");
        categoryRepository.save(category1);
        Category category2 = new Category("Ноутбуки");
        categoryRepository.save(category2);

        //Названия характеристик
        Specification_name specification_name1_1 = new Specification_name("Тип", category1);
        specification_nameRepository.save(specification_name1_1);
        Specification_name specification_name1_2 = new Specification_name("Версия ОС на начало продаж", category1);
        specification_nameRepository.save(specification_name1_2);
        Specification_name specification_name1_3 = new Specification_name("Тип корпуса", category1);
        specification_nameRepository.save(specification_name1_3);
        Specification_name specification_name1_4 = new Specification_name("Количество SIM-карт", category1);
        specification_nameRepository.save(specification_name1_4);
        Specification_name specification_name1_5 = new Specification_name("Тип SIM-карты", category1);
        specification_nameRepository.save(specification_name1_5);
        Specification_name specification_name1_6 = new Specification_name("Режим работы нескольких SIM-карт", category1);
        specification_nameRepository.save(specification_name1_6);
        Specification_name specification_name1_7 = new Specification_name("Бесконтактная оплата", category1);
        specification_nameRepository.save(specification_name1_7);
        Specification_name specification_name1_8 = new Specification_name("Вес", category1);
        specification_nameRepository.save(specification_name1_8);
        Specification_name specification_name1_9 = new Specification_name("Размеры (ШxВxТ)", category1);
        specification_nameRepository.save(specification_name1_9);
        Specification_name specification_name2_1 = new Specification_name("Линейка процессора", category2);
        specification_nameRepository.save(specification_name2_1);
        Specification_name specification_name2_2 = new Specification_name("Код процессора", category2);
        specification_nameRepository.save(specification_name2_2);
        Specification_name specification_name2_3 = new Specification_name("Размеры (ШxВxТ)", category2);
        specification_nameRepository.save(specification_name2_3);
        Specification_name specification_name2_4 = new Specification_name("Ядро процессора", category2);
        specification_nameRepository.save(specification_name2_4);
        Specification_name specification_name2_5 = new Specification_name("Частота процессора", category2);
        specification_nameRepository.save(specification_name2_5);
        Specification_name specification_name2_6 = new Specification_name("Количество ядер процессора", category2);
        specification_nameRepository.save(specification_name2_6);
        Specification_name specification_name2_7 = new Specification_name("Объем кэша L2", category2);
        specification_nameRepository.save(specification_name2_7);
        Specification_name specification_name2_8 = new Specification_name("Объем кэша L3", category2);
        specification_nameRepository.save(specification_name2_8);

        //Товары
        Product product1 = new Product("Смартфон SAMSUNG", 20000f, "Смартфон", category1);
        productRepository.save(product1);
        Product product2 = new Product("Ноутбук ACER", 40000f, "Ноутбук", category2);
        productRepository.save(product2);

        //Значения характеристик
        Specification_value specification_value1_1 = new Specification_value("смартфон", specification_name1_1, product1);
        specification_valueRepository.save(specification_value1_1);
        Specification_value specification_value1_2 = new Specification_value("Android 10", specification_name1_2, product1);
        specification_valueRepository.save(specification_value1_2);
        Specification_value specification_value1_3 = new Specification_value("классический", specification_name1_3, product1);
        specification_valueRepository.save(specification_value1_3);
        Specification_value specification_value1_4 = new Specification_value("2", specification_name1_4, product1);
        specification_valueRepository.save(specification_value1_4);
        Specification_value specification_value1_5 = new Specification_value("nano SIM", specification_name1_5, product1);
        specification_valueRepository.save(specification_value1_5);
        Specification_value specification_value1_6 = new Specification_value("попеременный", specification_name1_6, product1);
        specification_valueRepository.save(specification_value1_6);
        Specification_value specification_value1_7 = new Specification_value("есть", specification_name1_7, product1);
        specification_valueRepository.save(specification_value1_7);
        Specification_value specification_value1_8 = new Specification_value("185 г", specification_name1_8, product1);
        specification_valueRepository.save(specification_value1_8);
        Specification_value specification_value1_9 = new Specification_value("74.06x159.07x9.04 мм", specification_name1_9, product1);
        specification_valueRepository.save(specification_value1_9);
        Specification_value specification_value2_1 = new Specification_value("Core i5 / Ryzen 5 / Ryzen 7", specification_name2_1, product2);
        specification_valueRepository.save(specification_value2_1);
        Specification_value specification_value2_2 = new Specification_value("10210U / 2500U / 3700U / 8250U", specification_name2_2, product2);
        specification_valueRepository.save(specification_value2_2);
        Specification_value specification_value2_3 = new Specification_value("Comet Lake-U / Kaby Lake-R / Picasso", specification_name2_3, product2);
        specification_valueRepository.save(specification_value2_3);
        Specification_value specification_value2_4 = new Specification_value("1600...2300 МГц", specification_name2_4, product2);
        specification_valueRepository.save(specification_value2_4);
        Specification_value specification_value2_5 = new Specification_value("4", specification_name2_5, product2);
        specification_valueRepository.save(specification_value2_5);
        Specification_value specification_value2_6 = new Specification_value("1 МБ / 2 МБ", specification_name2_6, product2);
        specification_valueRepository.save(specification_value2_6);
        Specification_value specification_value2_7 = new Specification_value("4 МБ / 6 МБ", specification_name2_7, product2);
        specification_valueRepository.save(specification_value2_7);

        //Изображения
        File file1_1 = new File("build/resources/main/pictures/picture1_1.jpg");
        File file1_2 = new File("build/resources/main/pictures/picture1_2.jpg");
        File file1_3 = new File("build/resources/main/pictures/picture1_3.jpg");
        imageRepository.saveAndFlush(new Image("image/jpeg", Files.readAllBytes(file1_1.toPath()), product1));
        imageRepository.saveAndFlush(new Image("image/jpeg", Files.readAllBytes(file1_2.toPath()), product1));
        imageRepository.saveAndFlush(new Image("image/jpeg", Files.readAllBytes(file1_3.toPath()), product1));
        File file2_1 = new File("build/resources/main/pictures/picture2_1.jpg");
        File file2_2 = new File("build/resources/main/pictures/picture2_2.jpg");
        File file2_3 = new File("build/resources/main/pictures/picture2_3.jpg");
        imageRepository.saveAndFlush(new Image("image/jpeg", Files.readAllBytes(file2_1.toPath()), product2));
        imageRepository.saveAndFlush(new Image("image/jpeg", Files.readAllBytes(file2_2.toPath()), product2));
        imageRepository.saveAndFlush(new Image("image/jpeg", Files.readAllBytes(file2_3.toPath()), product2));
    }
}
