package core.beans;




import dao.entities.Menu;
import dao.entities.Submenu;

import java.io.Serializable;
import java.util.List;

public class MenuResponse implements Serializable {
    private Menu menu;
    private List<Submenu> submenus;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Submenu> getSubmenus() {
        return submenus;
    }

    public void setSubmenus(List<Submenu> submenus) {
        this.submenus = submenus;
    }

    @Override
    public String toString() {
        return "MenuResponse{" +
                "menu=" + menu +
                ", submenus=" + submenus +
                '}';
    }
}
