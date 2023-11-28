package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.enums;

public enum AccountStatus {
    ACTIVE(1), DE_ACTIVE(0), DELETE(-1);
    private int value;
    AccountStatus(int value) {
        this.value = value;
    }
}
