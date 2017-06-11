package Tech;

import javax.swing.table.DefaultTableModel;

/**
 * Created by Jacob on 11-06-2017.
 */
public class ModelMethods {

    public static void updateOverview(DefaultTableModel jtModel) {
        int rowCount = jtModel.getRowCount();

        for (int i = rowCount - 1; i >= 0 ; i--) {
            jtModel.removeRow(i);
        }
    }
}
