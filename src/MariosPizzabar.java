public class MariosPizzabar {

    public static void main(String[] args) {
         Menu menu = new Menu(1, "Hawaii",56.5, "cheese, tomatosause, ham, pineapple");
         Menu menu1 = new Menu(2, "Serano", 61,"chesse, tomatosauce, real ham");

         menu.addMenu(menu);
         menu.addMenu(menu1);

        System.out.println(Database.menuDetail);
    }
}
