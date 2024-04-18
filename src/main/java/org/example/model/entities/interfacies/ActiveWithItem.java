package org.example.model.entities.interfacies;


import org.example.model.entities.Product;

public interface ActiveWithItem {

    public void addItem(Product product);

    public void removeItem(Product product);

    public Product getItem();

    public void changeInforItem(Product product);

    public void updateItem(Product product);

    public void updateQuantityItem(Product product);


}
