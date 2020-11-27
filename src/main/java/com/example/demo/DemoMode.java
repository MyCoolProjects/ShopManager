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
    SpecificationNameRepository specificationNameRepository;

    @Autowired
    SpecificationValueRepository specificationValueRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadImage() throws IOException {

        // Категории
        Category category1 = new Category("Смартфоны");
        categoryRepository.save(category1);
        Category category2 = new Category("Ноутбуки");
        categoryRepository.save(category2);

        // Названия характеристик
        SpecificationName specification_name1_1 = new SpecificationName("Тип", category1);
        specificationNameRepository.save(specification_name1_1);
        SpecificationName specification_name1_2 = new SpecificationName("Версия ОС на начало продаж", category1);
        specificationNameRepository.save(specification_name1_2);
        SpecificationName specification_name1_3 = new SpecificationName("Тип корпуса", category1);
        specificationNameRepository.save(specification_name1_3);
        SpecificationName specification_name1_4 = new SpecificationName("Количество SIM-карт", category1);
        specificationNameRepository.save(specification_name1_4);
        SpecificationName specification_name1_5 = new SpecificationName("Тип SIM-карты", category1);
        specificationNameRepository.save(specification_name1_5);
        SpecificationName specification_name1_6 = new SpecificationName("Режим работы нескольких SIM-карт",
                category1);
        specificationNameRepository.save(specification_name1_6);
        SpecificationName specification_name1_7 = new SpecificationName("Бесконтактная оплата", category1);
        specificationNameRepository.save(specification_name1_7);
        SpecificationName specification_name1_8 = new SpecificationName("Вес", category1);
        specificationNameRepository.save(specification_name1_8);
        SpecificationName specification_name1_9 = new SpecificationName("Размеры (ШxВxТ)", category1);
        specificationNameRepository.save(specification_name1_9);
        SpecificationName specification_name2_1 = new SpecificationName("Линейка процессора", category2);
        specificationNameRepository.save(specification_name2_1);
        SpecificationName specification_name2_2 = new SpecificationName("Код процессора", category2);
        specificationNameRepository.save(specification_name2_2);
        SpecificationName specification_name2_3 = new SpecificationName("Размеры (ШxВxТ)", category2);
        specificationNameRepository.save(specification_name2_3);
        SpecificationName specification_name2_4 = new SpecificationName("Ядро процессора", category2);
        specificationNameRepository.save(specification_name2_4);
        SpecificationName specification_name2_5 = new SpecificationName("Частота процессора", category2);
        specificationNameRepository.save(specification_name2_5);
        SpecificationName specification_name2_6 = new SpecificationName("Количество ядер процессора", category2);
        specificationNameRepository.save(specification_name2_6);
        SpecificationName specification_name2_7 = new SpecificationName("Объем кэша L2", category2);
        specificationNameRepository.save(specification_name2_7);
        SpecificationName specification_name2_8 = new SpecificationName("Объем кэша L3", category2);
        specificationNameRepository.save(specification_name2_8);

        // Товары
        Product product1 = new Product("Смартфон SAMSUNG", 20000f, "Смартфон", category1);
        productRepository.save(product1);
        Product product2 = new Product("Ноутбук ACER", 40000f, "Ноутбук", category2);
        productRepository.save(product2);

        // Значения характеристик
        SpecificationValue specification_value1_1 = new SpecificationValue("смартфон", specification_name1_1,
                product1);
        specificationValueRepository.save(specification_value1_1);
        SpecificationValue specification_value1_2 = new SpecificationValue("Android 10", specification_name1_2,
                product1);
        specificationValueRepository.save(specification_value1_2);
        SpecificationValue specification_value1_3 = new SpecificationValue("классический", specification_name1_3,
                product1);
        specificationValueRepository.save(specification_value1_3);
        SpecificationValue specification_value1_4 = new SpecificationValue("2", specification_name1_4, product1);
        specificationValueRepository.save(specification_value1_4);
        SpecificationValue specification_value1_5 = new SpecificationValue("nano SIM", specification_name1_5,
                product1);
        specificationValueRepository.save(specification_value1_5);
        SpecificationValue specification_value1_6 = new SpecificationValue("попеременный", specification_name1_6,
                product1);
        specificationValueRepository.save(specification_value1_6);
        SpecificationValue specification_value1_7 = new SpecificationValue("есть", specification_name1_7, product1);
        specificationValueRepository.save(specification_value1_7);
        SpecificationValue specification_value1_8 = new SpecificationValue("185 г", specification_name1_8, product1);
        specificationValueRepository.save(specification_value1_8);
        SpecificationValue specification_value1_9 = new SpecificationValue("74.06x159.07x9.04 мм",
                specification_name1_9, product1);
        specificationValueRepository.save(specification_value1_9);
        SpecificationValue specification_value2_1 = new SpecificationValue("Core i5 / Ryzen 5 / Ryzen 7",
                specification_name2_1, product2);
        specificationValueRepository.save(specification_value2_1);
        SpecificationValue specification_value2_2 = new SpecificationValue("10210U / 2500U / 3700U / 8250U",
                specification_name2_2, product2);
        specificationValueRepository.save(specification_value2_2);
        SpecificationValue specification_value2_3 = new SpecificationValue("Comet Lake-U / Kaby Lake-R / Picasso",
                specification_name2_3, product2);
        specificationValueRepository.save(specification_value2_3);
        SpecificationValue specification_value2_4 = new SpecificationValue("1600...2300 МГц", specification_name2_4,
                product2);
        specificationValueRepository.save(specification_value2_4);
        SpecificationValue specification_value2_5 = new SpecificationValue("4", specification_name2_5, product2);
        specificationValueRepository.save(specification_value2_5);
        SpecificationValue specification_value2_6 = new SpecificationValue("1 МБ / 2 МБ", specification_name2_6,
                product2);
        specificationValueRepository.save(specification_value2_6);
        SpecificationValue specification_value2_7 = new SpecificationValue("4 МБ / 6 МБ", specification_name2_7,
                product2);
        specificationValueRepository.save(specification_value2_7);

        // Изображения
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
