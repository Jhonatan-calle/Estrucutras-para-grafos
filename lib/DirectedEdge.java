package lib;

import java.util.Objects;

public class DirectedEdge<T>{
    public final T from;
    public final T to;
    public final double weigth;

    public DirectedEdge(T from, T to, double weight){
        this.from = from;
        this.to = to;
        this.weigth = weight;
    }


    //esto define cuando un objeto es igual a otro sin necesidad de ser el mismo
    //por que por default java va a comparar los direcciones de memoria y no me sirve
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Mismo objeto
        if (obj == null || getClass() != obj.getClass()) return false; // Null o clases diferentes
        DirectedEdge<?> other = (DirectedEdge<?>) obj;
        return Double.compare(weigth, other.weigth) == 0 // Comparamos pesos con precisión
                && Objects.equals(from, other.from) // Comparamos nodos "from"
                && Objects.equals(to, other.to); // Comparamos nodos "to"
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, weigth); // Genera un hash consistente con equals
    }
}
