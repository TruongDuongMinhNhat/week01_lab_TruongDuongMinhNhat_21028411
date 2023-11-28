package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.enums;

public enum RoleStatus {
    ACTIVE(1), DE_ACTIVE(0), DELETE(-1);
    private int value;
    RoleStatus(int value) {
        this.value = value;
    }
}
