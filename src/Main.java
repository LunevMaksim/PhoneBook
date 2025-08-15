import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap <String, String> phoneBook = new HashMap<>();
        boolean value = true;
        while (value){
            System.out.println("===Доступные команды===");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Найти номер");
            System.out.println("3. Удалить контакт");
            System.out.println("4. Показать все контакты");
            System.out.println("5. Выход");
            System.out.print("Выбор: ");
            String action = scanner.nextLine();
            switch (action){
                case "1":
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите телефон: ");
                    String numbers = scanner.nextLine();
                    if (name.isEmpty() || numbers.isEmpty()){
                        System.out.println("Ошибка! Неверно введены имя или телефон");
                        break;
                    }
                    else {
                        if (phoneBook.containsValue(numbers)) {
                            System.out.println("Ошибка: этот номер уже существует!");
                            break;
                        }
                        phoneBook.put(name, numbers);
                        System.out.println("Контакт добавлен!");
                        break;
                    }
                case "2":
                    System.out.print("Введите имя для поиска: ");
                    String Nickname = scanner.nextLine();
                    if (phoneBook.containsKey(Nickname)){
                        System.out.println("Имя: " + Nickname + " Телефон: " + phoneBook.get(Nickname));
                        break;
                    }
                    else {
                        System.out.println("Пользователь не найден!");
                        break;
                    }
                case "3":
                    System.out.print("Введите имя для удаления: ");
                    String nick = scanner.nextLine();
                    if (phoneBook.containsKey(nick)){
                        phoneBook.remove(nick);
                        System.out.println("Контакт удален");
                        break;
                    }
                    else {
                        System.out.println("Пользователь не найден!");
                        break;
                    }
                case "4":
                    if (phoneBook.isEmpty()){
                        System.out.println("Список контактов пуст");
                        break;
                    }
                    else {
                        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
                        break;
                    }
                case "5":
                    value = false;
                    break;
                default:
                    System.out.println("Вы ввели неверный номер команды! Повторите попытку");
            }
        }
    }
}

