package servicios;

import dao.DaoProducto_cliente;
import io.vavr.control.Either;

import java.util.List;

public class SvProductos_cliente {
    public Either<String, List<String>> getTodosProductos() {
        DaoProducto_cliente daoProducto_cliente = new DaoProducto_cliente();
        return daoProducto_cliente.getTodosProductos();
    }

    public List addCesta(List list_productos) {
        DaoProducto_cliente daoProducto_cliente = new DaoProducto_cliente();
        return daoProducto_cliente.addCesta(list_productos);
    }

    public String buyCesta(List productosBuy) {
        DaoProducto_cliente daoProducto_cliente = new DaoProducto_cliente();
        return daoProducto_cliente.buyCesta(productosBuy);
    }

    public String clearCesta(List productosClear) {
        DaoProducto_cliente daoProducto_cliente = new DaoProducto_cliente();
        return daoProducto_cliente.clearCesta(productosClear);
    }
}
