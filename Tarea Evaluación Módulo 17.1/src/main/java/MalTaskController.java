// ======================================================================
//  LEGACY VERSION – CÓDIGO MAL HECHO CON 10 CODE SMELLS
// ======================================================================

public class MalTaskController {

    // SMELL #1 – TEMPORARY FIELD
    public int tempValue = 0;

    // SMELL #2 – LARGE CLASS (too many responsabilitys...)
    public void processTask(String name, int hours, double rate, String category,
                            String email, String address, String phone) {

        // SMELL #3 – LONG METHOD (too long...)
        // SMELL #4 – DUPLICATE CODE (repeting its self...)
        if (name == null || name.isEmpty()) {
            System.out.println("Error: name required");
            return;
        }
        if (email == null || !email.contains("@")) {
            System.out.println("Error: invalid email");
            return;
        }

        // SMELL #5 – INAPPROPRIATE INTIMACY (direct acces to data...)
        System.out.println("Updating user address: " + address);
        System.out.println("Updating user phone: " + phone);

        // SMELL #6 – SHOTGUN SURGERY (disperse data...)
        double total = hours * rate;
        double totalWithTax = total * 1.21;

        // SMELL #7 – SWITCH STATEMENT (it should be polimorfic...)
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

        // SMELL #8 – FEATURE ENVY (this logic should be in TASK...)
        if (name.contains("late")) {
            System.out.println("Task is late");
        }

        // SMELL #9 – DEAD CODE
        int unusedCounter = 0;

        // SMELL #10 – DIVERGENT CHANGE (user depends in too many changes...)
        System.out.println("Sending email to: " + email);
        System.out.println("Final total: " + totalWithTax);
    }
}
