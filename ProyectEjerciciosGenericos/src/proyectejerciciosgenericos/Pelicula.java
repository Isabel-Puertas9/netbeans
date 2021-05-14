/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectejerciciosgenericos;
        /**
 *
 * @author Profesor
 */
public class Pelicula extends Producto{
    protected String idioma;
    protected int duracion;
    protected String genero;
    protected static int contPeliculas=0;
    protected final static String IDIOMAS="ESPAÑOLFRANCÉSALEMÁNINGLÉSCHINO";

    public Pelicula(String idioma, int duracion, String genero, String nombre) throws IllegalArgumentException{
        super(nombre);
        idioma=idioma.trim().toUpperCase();
        if (!Pelicula.IDIOMAS.contains(idioma))
            throw new IllegalArgumentException("Idioma Incorrecto");
        this.idioma = idioma;
        if (duracion <= 0)
            throw new IllegalArgumentException("Duración Incorrecta");
        this.duracion = duracion;
        this.genero = genero.trim().toUpperCase();
        this.precio=2;
        Pelicula.contPeliculas++;
    }
    
    public Pelicula(Pelicula other){
        this(other.idioma, other.duracion, other.genero, other.nombre);
    }

    public String getIdioma() {
        return idioma;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    public static int getContPeliculas() {
        return contPeliculas;
    }

    @Override
    public double getPrecio() {
        return 2;
    }

    public void setIdioma(String idioma) throws IllegalArgumentException {
        idioma=idioma.trim().toUpperCase();
        if (!Pelicula.IDIOMAS.contains(idioma))
            throw new IllegalArgumentException("Idioma incorrecto");
        this.idioma = idioma;
    }

    public void setDuracion(int duracion) throws IllegalArgumentException{
        if (duracion<=0)
            throw new IllegalArgumentException("Duración incorrecta");
        this.duracion = duracion;
    }

    public void setGenero(String genero) {
        this.genero = genero.trim().toUpperCase();
    }

    @Override
    public String toString() {
        return "Pelicula{" +super.toString()+ "Idioma=" + idioma + " Duracion=" + duracion + " Género=" + genero + '}';
    }
    
    
    
}
