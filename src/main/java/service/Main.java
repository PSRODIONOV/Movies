package service;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;

//@SpringBootApplication( scanBasePackages = "com.accenture.itfactory")
public class Main {

    UserStorageImpl US;
    MoviesStorageImpl MS;

    enum step {DEFAULT, LOGIN, REGISTRATION,  EDIT};
    static step status = step.DEFAULT;
    static Scanner scan = new Scanner(System.in);

    public static void main1(String[] args){

        /*service.Main main = new service.Main();
        while(true){
            main.menu();
            main.action();
        }*/
        SpringApplication.run( Main.class, args);

    }

    public void menu(){
        System.out.println("#######################################");
        switch (status){
            case DEFAULT:
                System.out.println("Enter login/registration");
                break;
            case LOGIN:
                System.out.println("Раздел входа.");
                break;
            case REGISTRATION:
                System.out.println("Раздел регистрации.");
                break;
            case EDIT:
                System.out.println("Раздел редактирования.");
                break;
        }
    }

   /* public void action(){
        String Action = scan.nextLine();
        switch(Action){
            case "login":
                Login();
                break;
            case "registration":
                Registration();
                break;
            case "search":
                SearchMovie();
                break;
            case "infomovie":
                InfoMovie();
                break;
            case "addcomment":
                addReview();
                break;
            case "comment":
                editComment();
                break;
            case "logout":
                LogOut();
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Ошибка. Действие не найдено.");
                break;
        }
    }
    public void SearchMovie(){
        if(status != step.EDIT){
            System.out.println("Ошибка. Действие не найдено.");
            return;
        }
        System.out.println("Поиск");
        System.out.println("Введите ключ поиска");
        String key = scan.nextLine();
        if(!MS.searchMovie(key))
            System.out.println("Not found.");
        else{
            for (Movie a: MS.getFoundMovieList()) {
                System.out.println("IMDB "+ a.getRating() + " Name "+ a.getPrimaryTitle());
            }
        }

    }

    public void InfoMovie(){
        if(status != step.EDIT){
            System.out.println("Ошибка. Действие не найдено.");
            return;
        }
        System.out.println("Информация о фильме");
        System.out.println("Введите ID фильма:");
        int ID = scan.nextInt();
        scan.nextLine();
        Movie fm = MS.getMovieById(ID);
        if(fm == null)
            System.out.println("Ошибка. Неверный ID.");
        else fm.printInfo();
    }
    public void editComment(){
        if(!US.currentUser.checkAdmin() || status != step.EDIT){
            System.out.println("Ошибка. Действие не найдено.");
            return;
        }
        System.out.println("Редактирование комментария");
        System.out.println("Введите ID фильма:");
        int idMovie = scan.nextInt();
        scan.nextLine();
        System.out.println("Введите ID комментария:");
        long idComment = scan.nextLong();
        scan.nextLine();

        Review fc = MS.getMovieById(idMovie).getReviewById(idComment);
        if(fc == null) {
           System.out.println("Ошибка. Не найден фильм или комментарий.");
            return;
        }
        System.out.println("Выбериет действие");
        String action = scan.nextLine();
        switch(action){
            case "delete":
                MS.delComment(idMovie, idComment);
                System.out.println("Комментарий удален.");
                break;
            case "edit":
                StringSelection ss = new StringSelection(fc.getText());
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);//добавление в буфер обмена коментарий, который хотим отредактировать
                String buf = scan.nextLine();
                MS.editComment(idMovie, idComment, buf);
                System.out.println("Комментарий успешно отредактирован.");
                break;
        }
               // scan.nextLine();
    }
    public void addReview(){
        if(US.currentUser.checkAdmin() || status != step.EDIT) {
            System.out.println("Ошибка. Действие не найдено.");
            return;
        }
        System.out.println("Добавление комментария");
        System.out.println("Введите ID фильма:");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("Введите комментарий:");
        String text = scan.nextLine();
        System.out.println("Введите рейтинг:");
        float rating = scan.nextFloat();
        if(MS.addReview(id, US.currentUser.getlogin(),text, rating))
            System.out.println("Комментарий успешно добавлен");
        else
            System.out.println("Ошибка. Неверный ID.");
        scan.nextLine();
    }

    public void Registration(){
        if(status != step.DEFAULT) {
            System.out.println("Ошибка. Действие не найдено.");
            return;
        }
        System.out.println("Регистрация");
        status = step.REGISTRATION;
        System.out.println("Логин:");
        String login = scan.nextLine();
        System.out.println("Пароль:");
        String password = scan.nextLine();
        if(US.registration(login, password, 0))
            System.out.println("Пользователь успешно добавлен.");
        else
            System.out.println("Такой пользователь уже существует.");
        status = step.DEFAULT;
    }

    public void Login(){
        if(status != step.DEFAULT) {
            System.out.println("Ошибка. Действие не найдено.");
            return;
        }
        System.out.println("Вход");
        status = step.LOGIN;
        System.out.println("Логин:");
        String login = scan.nextLine();
        System.out.println("Пароль:");
        String password = scan.nextLine();
        if(US.login(login, password)) {
            System.out.println("Вы успешно зашли в систему.");
            status = step.EDIT;
        }
        else {
            System.out.println("Ошибка. Неверный логин или пароль.");
            status = step.DEFAULT;
        }
    }

    public void LogOut(){
        if(status == step.DEFAULT) {
            System.out.println("Для начала нужно войти под пользователем.");
            return;
        }
        US.logout();
        status = step.DEFAULT;
        System.out.println("Вы успешно вышли.");
    }*/
}
