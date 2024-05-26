package org.example.controller.productController;

import jakarta.persistence.EntityManager;
import org.example.model.entities.Product;
import org.example.service.ServiceProduct;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.List;

public class ProductController {

    private final EntityManager em;

    private ServiceProduct serviceProduct;

    public ProductController(EntityManager em) {
        this.em = em;
    }

    public void showDataProductTbl(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        serviceProduct = new ServiceProduct(em);
        List<Product> dataAdd = serviceProduct.findAllProduct();
        for(Product product : dataAdd) {
            model.addRow(new Object[] {
                            product.getIdProduct(),
                            product.getNameProduct(),
                            product.getQuantityProduct(),
                            product.getUnitProduct(),
                            product.getPrice(),
                            null,
                            product.getMota()
                    }
            );
        }

        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(model);
        table.setRowSorter(rowSorter);
    }

    public boolean deleteProduct(Product product) {
        boolean result = serviceProduct.delProduct(product);
        return result;
    }
}
