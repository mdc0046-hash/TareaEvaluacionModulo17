// ======================================================================
//  LEGACY VERSION – CÓDIGO MAL HECHO CON 10 CODE SMELLS
//  (Este es el archivo que mostrarás como "ANTES")
// ======================================================================

public class MalTaskController {

    // SMELL #1 – TEMPORARY FIELD
    public int tempValue = 0;

    // SMELL #2 – LARGE CLASS (demasiadas responsabilidades)
    public void processTask(String name, int hours, double rate, String category,
                            String email, String address, String phone) {

        // SMELL #3 – LONG METHOD (demasiado largo)
        // SMELL #4 – DUPLICATE CODE (validación repetida)
        if (name == null || name.isEmpty()) {
            System.out.println("Error: name required");
            return;
        }
        if (email == null || !email.contains("@")) {
            System.out.println("Error: invalid email");
            return;
        }

        // SMELL #5 – INAPPROPRIATE INTIMACY (acceso directo a datos)
        System.out.println("Updating user address: " + address);
        System.out.println("Updating user phone: " + phone);

        // SMELL #6 – SHOTGUN SURGERY (cálculo de impuestos disperso)
        double total = hours * rate;
        double totalWithTax = total * 1.21;

        // SMELL #7 – SWITCH STATEMENT (debería ser polimorfismo)
        switch (category) {
            case "URGENT":
                totalWithTax -= 20;
                break;
            case "NORMAL":
                totalWithTax -= 5;
                break;
            case "LOW":
                totalWithTax -= 2;
                break;
        }

        // SMELL #8 – FEATURE ENVY (lógica que debería estar en Task)
        if (name.contains("late")) {
            System.out.println("Task is late");
        }

        // SMELL #9 – DEAD CODE
        int unusedCounter = 0;

        // SMELL #10 – DIVERGENT CHANGE (User depende de demasiados cambios)
        System.out.println("Sending email to: " + email);
        System.out.println("Final total: " + totalWithTax);
    }
}
