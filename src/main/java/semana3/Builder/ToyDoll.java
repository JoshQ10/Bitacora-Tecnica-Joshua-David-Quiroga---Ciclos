package semana3.Builder;

public class ToyDoll {

    private String head;
    private String body;
    private String arms;
    private String legs;
    private String accessories;

    public void setHead(String head) {
        this.head = head;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setArms(String arms) {
        this.arms = arms;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public void showInfo() {
        System.out.println("=== Muñeco ===");
        System.out.println("Cabeza: " + head);
        System.out.println("Cuerpo: " + body);
        System.out.println("Brazos: " + arms);
        System.out.println("Piernas: " + legs);
        if (accessories != null) {
            System.out.println("Accesorios: " + accessories);
        } else {
            System.out.println("Accesorios: Ninguno");
        }
        System.out.println();
    }
}
