package org.example.controller.productController;

import com.sun.jna.platform.win32.Netapi32Util;
import jakarta.persistence.EntityManager;
import org.example.controller.userController.UserInfoController;
import org.example.model.entities.Product;
import org.example.model.entities.UserApp;
import org.example.service.ServiceProduct;
import org.example.service.ServiceUserApp;
import org.example.view.dashboart.application.form.login.util.UserSession;
import org.example.view.dashboart.application.form.other.UserInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.List;

public class ProductController {

    private final EntityManager em;

    private ServiceProduct serviceProduct;

    private ServiceUserApp serviceUserApp;

    public ProductController(EntityManager em) {
        this.em = em;
        serviceProduct = new ServiceProduct(em);
        serviceUserApp = new ServiceUserApp(em);
    }

    public void showDataProductTbl(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

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

    public Product findProductById(int id) {
        return serviceProduct.findById(id);
    }
    public void updateProductInFrame(int id, Product newDateUpdate) {
        serviceProduct.updateProduct(id, newDateUpdate);
    }
    public void showDataSuplierTbl(JTable table, int idProduct) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Product product = serviceProduct.findById(idProduct);
        List<UserApp> dataAdd = product.getSupplier();
        if(dataAdd.size() > 0 || !dataAdd.isEmpty()) {
            for(UserApp userApp : dataAdd) {
                model.addRow(new Object[] {
                        userApp.getIdUser(),
                        userApp.getName(),
                        userApp.getUserName(),
                        userApp.getPhoneNumber()
                });
            }
        }

    }

    public void showDataTblImport(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        UserApp userApp = serviceUserApp.findUserAppById(UserSession.getIdUser());
        List<Product> dataAdd = userApp.getProductList();
        if(dataAdd == null) {
            model.addRow(new Object[]{});
        } else {
            for (Product product : dataAdd) {
                model.addRow(new Object[]{
                product.getIdProduct(),
                product.getNameProduct(),
                product.getUnitProduct(),
                product.getPrice(),

            });
        }
        }
    }

    public List<Product> showDataTblChoose(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        List<Product> dataAdd = serviceProduct.findAllProduct();
        if(dataAdd == null) {
            model.addRow(new Object[]{});
            return dataAdd;
            } else {
                for (Product product : dataAdd) {
                    model.addRow(new Object[]{
                            false,
                            product.getIdProduct(),
                            product.getNameProduct(),
                            product.getQuantityProduct(),
                            product.getUnitProduct(),
                            product.getPrice(),
                            product.getMota()

                    });
                }
            }
        return dataAdd;
    }
    public boolean deleteProduct(Product product) {
        boolean result = serviceProduct.delProduct(product);
        return result;
    }

    public void insertProduct(Product product) {
        serviceProduct.inserProduct(product);
    }

    public void updataProduct(Product product, Long quantity) {
        serviceProduct.updateQuantityProduct(product, quantity);

    }
}
