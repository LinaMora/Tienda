/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Desarrollo de Software - Guía 2 - Actividad 2
 * Ejercicio: tienda
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package mundo;

/**
 * Tienda que maneja 4 productos.
 */
public class Tienda {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Producto 1 de la tienda.
     */
    private Producto producto1;

    /**
     * Producto 2 de la tienda.
     */
    private Producto producto2;

    /**
     * Producto 3 de la tienda.
     */
    private Producto producto3;

    /**
     * Producto 4 de la tienda.
     */
    private Producto producto4;

    /**
     * Dinero total recibido por las ventas.
     */
    private double dineroEnCaja;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la tienda con sus 4 productos. <br>
     * <b> post: </b> El dinero en caja fue inicializado en 0.<br>
     * Los 4 productos fueron inicializados con los siguientes valores: <br>
     * Producto 1 - Tipo: PAPELERIA, Nombre: Lápiz, Valor unitario: 550.0, Cantidad en bodega: 18, Cantidad mínima: 5, Imagen: lapiz.png. <br>
     * Producto 2 - Tipo: DROGUERIA, Nombre: Aspirina, Valor unitario: 109.5, Cantidad en bodega: 25, Cantidad mínima: 8, Imagen: aspirina.png. <br>
     * Producto 3 - Tipo: PAPELERIA, Nombre: Borrador, Valor unitario: 207.3, Cantidad en bodega: 30, Cantidad mínima: 10, Imagen: borrador.png. <br>
     * Producto 4 - Tipo: SUPERMERCADO, Nombre: Pan, Valor unitario: 150.0, Cantidad en bodega: 15, Cantidad mínima: 20, Imagen: pan.png. <br>
     */
    public Tienda() {
        producto1 = new Producto("papeleria", "Lapiz", 550.0, 18, 5, "lapiz.png");
        producto2 = new Producto("drogueria", "Aspirina", 109.5, 25, 8, "aspirina.png");
        producto3 = new Producto("papeleria", "Borrador", 207.3, 30, 10, "borrador.png");
        producto4 = new Producto("supermercado", "Pan", 150.0, 15, 20, "pan.png");
        dineroEnCaja = 0;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el producto 1.
     *
     * @return Producto 1 de la tienda.
     */
    public Producto darPrimerProducto() {
        return producto1;
    }

    /**
     * Retorna el producto 2.
     *
     * @return Producto 2 de la tienda.
     */
    public Producto darSegundoProducto() {
        return producto2;
    }

    /**
     * Retorna el producto 3.
     *
     * @return Producto 3 de la tienda.
     */
    public Producto darTercerProducto() {
        return producto3;
    }

    /**
     * Retorna el producto 4.
     *
     * @return Producto 4 de la tienda.
     */
    public Producto darCuartoProducto() {
        return producto4;
    }

    /**
     * Retorna el dinero en caja.
     *
     * @return Dinero en caja.
     */
    public double darDineroEnCaja() {
        return dineroEnCaja;
    }

    /**
     * Retorna el producto con el nombre dado por parámetro.
     *
     * @param pNombre Nombre del producto buscado. pNombre != null && pNombre != "".
     * @return Producto con el nombre dado por parámetro, null si no lo encuentra.
     */
    public Producto darProducto(String pNombre) {
        Producto buscado = null;
        if(producto1.darNombre().equalsIgnoreCase(pNombre)){
            buscado = producto1;
        } else if (producto2.darNombre().equalsIgnoreCase(pNombre)) {
            buscado = producto2;
        } else if (producto3.darNombre().equalsIgnoreCase(pNombre)) {
            buscado = producto3;
        } else if(producto4.darNombre().equalsIgnoreCase(pNombre)){
            buscado = producto4;
        }
        return buscado;

    }

    /**
     * Retorna el promedio de las ventas.
     *
     * @return Dinero promedio obtenido por unidad de producto vendida.
     */
    public double darPromedioVentas() {
        double respuesta = 0.0;
        int unidadesVendidas = producto1.darCantidadUnidadesVendidas();
        unidadesVendidas += producto2.darCantidadUnidadesVendidas();
        unidadesVendidas += producto3.darCantidadUnidadesVendidas();
        unidadesVendidas += producto4.darCantidadUnidadesVendidas();
        if(unidadesVendidas == 0){
            respuesta = 0.0;
        }else{
            respuesta = this.dineroEnCaja / unidadesVendidas;
        }

        return respuesta;
    }

    /**
     * Retorna el producto con más unidades vendidas.
     *
     * @return Producto con más unidades vendidas. Null si ningún producto tiene unidades vendidas.
     */
    public Producto darProductoMasVendido() {
        Producto masVendido = null;
        int mayor = producto1.darCantidadUnidadesVendidas();
        masVendido = producto1;
        if(mayor < producto2.darCantidadUnidadesVendidas()){
            mayor = producto2.darCantidadUnidadesVendidas();
            masVendido = producto2;
        }
        if(mayor < producto3.darCantidadUnidadesVendidas()){
            mayor = producto3.darCantidadUnidadesVendidas();
            masVendido = producto3;
        }
        if(mayor <  producto4.darCantidadUnidadesVendidas()){
            masVendido = producto4;
        }

        return masVendido;
    }

    /**
     * Retorna el producto con menos unidades vendidas.
     *
     * @return Producto con menos unidades vendidas. Null si ningún producto tiene unidades vendidas.
     */
    public Producto darProductoMenosVendido() {
        Producto menosVendido = null;

        int menor = producto1.darCantidadUnidadesVendidas();
        menosVendido = producto1;
        if(menor > producto2.darCantidadUnidadesVendidas()){
            menor = producto2.darCantidadUnidadesVendidas();
            menosVendido = producto2;
        }
        if(menor > producto3.darCantidadUnidadesVendidas()){
            menor = producto3.darCantidadUnidadesVendidas();
            menosVendido = producto3;
        }
        if(menor > producto4.darCantidadUnidadesVendidas()){
            menosVendido = producto4;
        }

        return menosVendido;
    }

    /**
     * Vende una cantidad de unidades de producto de la tienda, dado su nombre por parámetro. <br>
     * <b>post: </b> Disminuyó la cantidad de unidades del producto dado
     * y se actualizó el dinero de la caja a partir de la cantidad real vendida multiplicada
     * por el precio final (con IVA) del producto vendido..
     *
     * @param pNombreProducto Nombre del producto a vender.
     * @param pCantidad       Cantidad de unidades del producto a vender. pCantidad > 0.
     * @return Cantidad que fue efectivamente vendida.
     */
    public int venderProducto(String pNombreProducto, int pCantidad) {
        Producto producto = darProducto(pNombreProducto);
        int cantidadVendida=producto.vender(pCantidad);
        dineroEnCaja += (cantidadVendida * (producto.darValorUnitario() + (producto.darValorUnitario()*producto.darIVA()/100)) );
        return cantidadVendida;
    }

    /**
     * Abastece un producto dado su nombre, con la cantidad de unidades dadas. <br>
     * <b>post: </b> Aumentó la cantidad de unidades en bodega del producto dado.
     *
     * @param pNombreProducto Nombre del producto a abastecer.
     * @param pCantidad       La cantidad de unidades a abastecer. cantidad >= 0.
     * @return Retorna true si se pudo efectuar el abastecimiento, false en caso contrario.
     */
    public boolean abastecerProducto(String pNombreProducto, int pCantidad) {
        boolean abastece = false;
        Producto producto = darProducto(pNombreProducto);
        if(producto.puedeAbastecer()){
         producto.abastecer(pCantidad);
         abastece = true;
        }
        return abastece;
    }

    /**
     * Cambia el producto que tiene el nombre actual con los nuevos valores dados por parámetro. <br>
     * <b>post: </b> El nombre, tipo, valor unitario, cantidad en bodega y cantidad mínima fueron cambiados con los valores dados por parámetro.
     *
     * @param pNombreActual   Nombre actual del producto.
     * @param pNombreNuevo    Nuevo nombre del producto.
     * @param pTipo           Tipo del producto.
     * @param pValorUnitario  Valor unitario del producto
     * @param pCantidadBodega Cantidad en bodega del producto.
     * @param pCantidadMinima Cantidad mínima en bodega para hacer un pedido del producto.
     * @param pRutaImagen     Ruta de la imagen del producto.
     * @return Retorna true si cambió la información del producto,
     * Retorna false si ya existía un producto con el nuevo nombre.
     */
    public boolean cambiarProducto(String pNombreActual, String pNombreNuevo, String pTipo, double pValorUnitario, int pCantidadBodega, int pCantidadMinima, String pRutaImagen) {
        boolean cambio = false;

        // TODO: Cambiar la información del producto, si y solo si, no existe el producto
        // TODO: con el nombre nuevo.
        Producto producto = darProducto(pNombreNuevo);
        //si y solo si no existe
        if(producto == null){
            Producto nuevoProducto =  new Producto(pTipo, pNombreNuevo, pValorUnitario, pCantidadBodega, pCantidadMinima, pRutaImagen);
            if(producto1.darNombre().equalsIgnoreCase(pNombreActual)){
                producto1 = nuevoProducto;
                cambio = true;
            } else if (producto2.darNombre().equalsIgnoreCase(pNombreActual)) {
                producto2 = nuevoProducto;
                cambio = true;
            } else if (producto3.darNombre().equalsIgnoreCase(pNombreActual)) {
                producto3 = nuevoProducto;
                cambio = true;
            } else if(producto4.darNombre().equalsIgnoreCase(pNombreActual)){
                producto4 = nuevoProducto;
                cambio = true;
            }

        }
        return cambio;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Obtiene la cantidad de productos que tienen un precio inferior al promedio de los precios
     */
    public int metodo1() {
        double promedio = (producto1.calcularPrecioFinal() + producto2.calcularPrecioFinal() + producto3.calcularPrecioFinal() + producto4.calcularPrecioFinal()) / 4.0;
        int respuesta = 0;
        if(producto1.calcularPrecioFinal() < promedio){
            respuesta++;
        }
        if(producto2.calcularPrecioFinal() < promedio){
            respuesta++;
        }
        if(producto3.calcularPrecioFinal() < promedio){
            respuesta++;
        }
        if(producto4.calcularPrecioFinal() < promedio){
            respuesta++;
        }
        return respuesta;
    }

    /**
     * Obtiene el nombre del producto más barato de la tienda
     */
    public String metodo2() {
        Producto barato = producto1;
        if(producto2.calcularPrecioFinal() < barato.calcularPrecioFinal()){
            barato = producto2;
        }
        if(producto3.calcularPrecioFinal() < barato.calcularPrecioFinal()){
            barato = producto3;
        }
        if(producto4.calcularPrecioFinal() < barato.calcularPrecioFinal()){
            barato = producto4;
        }

        return barato.darNombre();
    }
}