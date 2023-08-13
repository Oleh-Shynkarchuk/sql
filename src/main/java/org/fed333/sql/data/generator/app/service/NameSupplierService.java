package org.fed333.sql.data.generator.app.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NameSupplierService {

    private final Random random = new Random(System.nanoTime());

    private static final String[] NAMES_EN = {
            "Roman", "Serhiy", "Ivan", "Mykhailo", "Oleksandr", "Andriy", "Artem",
            "Iryna", "Tetyana", "Natalia", "Oksana", "Anastasia", "Olga", "Bohdana",
            "Bohdan", "Oleg", "Viacheslav", "Ruslan", "Dmytro", "Ihor", "Hlib",
            "Maria", "Krystyna", "Svitlana", "Kateryna", "Alina", "Amina", "Rosa",
            "Lybomyr", "Rostyslav", "Sviatoslav", "Vasyl", "Petro", "Maksym", "Adam",
            "Alisa", "Valeria", "Sophia", "Karyna", "Lilia", "Nina", "Lyudmyla",
            "Zahar", "Vladyslav", "Vadym", "Kyrylo", "Yaroslav", "Volodymyr", "Valentyn",
            "Yana", "Lina", "Anhelina", "Polina", "Vita", "Evelina", "Karolina",
            "Taras", "Mykyta", "Yuriy", "Pavlo", "Klym", "Leonid", "Eugene",
            "Anna", "Tina", "Solomia", "Stefania", "Ruslana", "Olesia", "Ilona",
            "Stepan", "Arkadiy", "Borys", "Symon", "Askold", "Trohym", "Sebastian",
            "Zhanna", "Snizhanna", "Margaryta", "Diana", "Valentyna", "Viktoria", "Elsa",
            "Mykola", "Denys", "Grygoriy", "Myroslav", "Vitaliy", "Nil", "Lev",
            "Tamara", "Zoya", "Marta", "Vladyslava", "Oleksandra", "Dasha", "Nadia",
            "Anton", "Isia", "Moisha", "Gennadiy", "Mstyslav", "Boryslav", "Jakiv",
            "Vira", "Lyubov", "Eva", "Isabella", "Mia", "Olena", "Evdokia"
    };

    private static final String[] NAMES = {
            "Роман", "Сергій", "Іван", "Михайло", "Олександр", "Андрій", "Артем",
            "Ірина", "Тетяна", "Наталія", "Оксана", "Анастасія", "Ольга", "Богдана",
            "Богдан", "Олег", "В'ячеслав", "Руслан", "Дмитро", "Ігор", "Гліб",
            "Марія", "Христина", "Світлана", "Катерина", "Аліна", "Аміна", "Роза",
            "Либомир", "Ростислав", "Святослав", "Василь", "Петро", "Максим", "Адам",
            "Аліса", "Валерія", "Софія", "Карина", "Лілія", "Ніна", "Людмила",
            "Захар", "Владислав", "Вадим", "Кирило", "Ярослав", "Володимир", "Валентин",
            "Яна", "Ліна", "Ангеліна", "Поліна", "Віта", "Евеліна", "Кароліна",
            "Тарас", "Микита", "Юрій", "Павло", "Клим", "Леонід", "Євген",
            "Анна", "Тіна", "Соломія", "Стефанія", "Руслана", "Олеся", "Ілона",
            "Степан", "Аркадій", "Борис", "Симон", "Аскольд", "Трохим", "Севастіан",
            "Жанна", "Сніжанна", "Маргарита", "Діана", "Валентина", "Вікторія", "Ельза",
            "Микола", "Денис", "Григорій", "Мирослав", "Віталій", "Ніл", "Лев",
            "Тамара", "Зоя", "Марта", "Владислава", "Олександра", "Даша", "Надія",
            "Антон", "Ізя", "Мойша", "Геннадій", "Мстислав", "Борислав", "Яків",
            "Віра", "Любов", "Єва", "Ізабелла", "Мія", "Олена", "Євдокія"
    };

    public String getName() {
        return NAMES[random.nextInt(NAMES.length)];
    }

}
