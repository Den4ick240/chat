module ru.nsu.ccfit.zhigalov {
    requires javafx.controls;
    requires javafx.fxml;

    opens ru.nsu.ccfit.zhigalov to javafx.fxml;
    exports ru.nsu.ccfit.zhigalov;
}