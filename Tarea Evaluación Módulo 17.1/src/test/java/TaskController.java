package com.project;

import java.util.ArrayList;
import java.util.List;

/* ============================================================
   ===============   LEGACY VERSION (SMELLY)   =================
   ============================================================ */

class LegacyTask {
    // INAPPROPRIATE INTIMACY (Smell #1)
    public String title;
    public String description;
    public String type;
    public int priority;

    // DEAD CODE (Smell #2)
    public void legacyExport() {
        // never used
    }
}

class LegacyTaskService {

    // TEMPORARY FIELD (Smell #3)
    public int tempDiscount;

    // LARGE CLASS (Smell #4)
    public void save(LegacyTask task) {
        System.out.println("Saving task: " + task.title);
    }

    // SWITCH STATEMENT (Smell #5)
    public int calculatePriority(String type) {
        switch (type) {
            case "BUG": return 10;
            case "FEATURE": return 5;
            case "CHORE": return 1;
            default: return 0;
        }
    }

    // FEATURE ENVY (Smell #6)
    public boolean isLate(LegacyTask task) {
        return task.title.contains("late");
    }
}

public class TaskController {

    LegacyTaskService legacyService = new LegacyTaskService();

    /* ============================================================
       LONG METHOD (Smell #7)
       DUPLICATED CODE (Smell #8)
       SHOTGUN SURGERY (Smell #9)
       ============================================================ */

    public String saveTaskLegacy(String title, String description, String type) {

        // Duplicate instance
        if (title == null || title.isEmpty()) {
            return "Error: title required";
        }
        if (description == null || description.isEmpty()) {
            return "Error: description required";
        }

        // Mixed logic
        LegacyTask task = new LegacyTask();
        task.title = title;
        task.description = description;
        task.type = type;

        // Even more duplicate instances
        if (title.length() > 50) {
            return "Error: title too long";
        }

        // TEMPORARY FIELD
        legacyService.tempDiscount = 10;

        // SWITCH
        int priority = legacyService.calculatePriority(type);
        task.priority = priority;

        // SHOTGUN SURGERY: Mixed notifications
        System.out.println("Email sent to user");

        // Save
        legacyService.save(task);

        return "OK";
    }

    /* ============================================================
       ===============   CLEAN VERSION (REFACTORED)   =============
       ============================================================ */

    // ---------- CLEAN MODEL ----------
    class Task {
        private String title;
        private String description;
        private String type;
        private int priority;

        public Task(String title, String description, String type) {
            this.title = title;
            this.description = description;
            this.type = type;
        }

        public boolean isLate() {
            return title.contains("late");
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getType() {
            return type;
        }
    }

    // ---------- CLEAN VALIDATOR ----------
    class TaskValidator {
        public String validate(String title, String description) {
            if (title == null || title.isEmpty()) return "Error: title required";
            if (description == null || description.isEmpty()) return "Error: description required";
            if (title.length() > 50) return "Error: title too long";
            return "OK";
        }
    }

    // ---------- CLEAN PRIORITY STRATEGY ----------
    interface PriorityStrategy {
        int calculate();
    }

    class BugPriority implements PriorityStrategy {
        public int calculate() { return 10; }
    }

    class FeaturePriority implements PriorityStrategy {
        public int calculate() { return 5; }
    }

    class DefaultPriority implements PriorityStrategy {
        public int calculate() { return 0; }
    }

    // ---------- CLEAN NOTIFIER ----------
    class TaskNotifier {
        public void send(Task task) {
            System.out.println("Email sent for task: " + task);
        }
    }

    // ---------- CLEAN SERVICE ----------
    class TaskService {

        TaskNotifier notifier = new TaskNotifier();

        public void assignPriority(Task task) {
            PriorityStrategy strategy = switch (task.getType()) {
                case "BUG" -> new BugPriority();
                case "FEATURE" -> new FeaturePriority();
                default -> new DefaultPriority();
            };
            task.setPriority(strategy.calculate());
        }

        public void save(Task task) {
            System.out.println("Saving task: " + task);
        }

        public void notifyUser(Task task) {
            notifier.send(task);
        }
    }

    // ---------- CLEAN CONTROLLER ----------
    TaskValidator validator = new TaskValidator();
    TaskService cleanService = new TaskService();

    public String saveTaskClean(String title, String description, String type) {

        String validation = validator.validate(title, description);
        if (!validation.equals("OK")) return validation;

        Task task = new Task(title, description, type);

        cleanService.assignPriority(task);
        cleanService.save(task);
        cleanService.notifyUser(task);

        return "OK";
    }
}
