
public class ListArrayOfInteger {

    private static final int INITIAL_SIZE = 10;
    private Integer[] data;
    private int count;

    /**
     * Construtor da lista
     */
    public ListArrayOfInteger() {
        this(INITIAL_SIZE);
    }

    /**
     * Construtor da lista
     *
     * @param tam tamanho inicial a ser alocado para a lista
     */
    public ListArrayOfInteger(int tam) {
        if (tam <= 0) {
            tam = INITIAL_SIZE;
        }
        data = new Integer[tam];
        count = 0;
    }

    /**
     * Esvazia a lista
     */
    public void clear() {
        data = new Integer[INITIAL_SIZE];
        count = 0;
    }

    /**
     * Retorna true se a lista não contêm elementos
     *
     * @return true se a lista não contêm elementos
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Retorna o número de elementos da lista
     *
     * @return o número de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Adiciona um elemento ao final da lista
     *
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) {
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        data[count] = element;
        count++;
    }

    /**
     * Insere um elemento em uma determinada posição da lista
     *
     * @param index   a posição da lista onde o elemento será inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        if (count == data.length) {
            setCapacity(data.length * 2);
        }

        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        count++;
    }

    /**
     * Remove o elemento de uma determinada posição da lista
     *
     * @param index a posição da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int removeByIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        int aux = data[index];

        for (int i = index; i < count - 1; i++) {
            data[i] = data[i + 1];
        }

        data[count - 1] = null;
        count--;

        if (count <= data.length / 4) {
            setCapacity(data.length / 2);
            System.out.println("Nova capacidade setada para " + (data.length / 2));
        }

        return aux;
    }

    /**
     * Remove a primeira ocorrência do elemento na lista, se estiver presente
     *
     * @param element o elemento a ser removido
     * @return true se a lista contém o elemento especificado
     */
    public boolean remove(Integer element) {

        for (int i = 0; i < count; i++) {

            if (element.equals(data[i])) {
                for (int j = i; j < count - 1; j++) {
                    data[j] = data[j + 1];
                }
                data[count - 1] = null;
                count--;
                if (count <= data.length / 4) {
                    setCapacity(data.length / 2);
                    System.out.println("Nova capacidade setada para " + (data.length / 2));
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna o elemento de uma determinada posição da lista
     *
     * @param index a posição da lista
     * @return o elemento da posição especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        return data[index];
    }

    /**
     * Substitui o elemento armanzenado em uma determinada posição da lista pelo
     * elemento indicado
     *
     * @param index   a posição da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posição da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int set(int index, Integer element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        int item = data[index];
        data[index] = element;
        return item;
    }

    /**
     * Retorna true se a lista contém o elemento especificado
     *
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(Integer element) {
        for (int p = 0; p < count; p++) {
            if (data[p].equals(element)) {
                return true;
            }
        }
        // Neste ponto, não achou: retorna falso
        return false;
    }

    /**
     * Retorna o índice da primeira ocorrência do elemento na lista, ou -1 se a
     * lista não contém o elemento
     *
     * @param element o elemento a ser buscado
     * @return o índice da primeira ocorrência do elemento na lista, ou -1 se a
     * lista não contém o elemento
     */
    public int indexOf(Integer element) {
        // Procura elemento no array, se achar retorna
        for (int i = 0; i < count; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        // Neste ponto, não achou: retorna -1
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count; i++) {
            s.append(data[i]);
            if (i != (count - 1)) {
                s.append(",");
            }
        }
        s.append("\n");
        return s.toString();
    }

    private void setCapacity(int newCapacity) {
        if (newCapacity != data.length) {
            int min = 0;
            Integer[] newData = new Integer[newCapacity];
            if (data.length < newCapacity) {
                min = data.length;
            } else {
                min = newCapacity;
            }
            for (int i = 0; i < min; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    // Este método retorna um arranjo com os elementos da lista original entre fromIndex (inclusivo) e toIndex (exclusivo).
    public int[] subList(int fromIndex, int toIndex) {
        if ((fromIndex < 0) || (fromIndex >= count) || (toIndex < 0) || (toIndex >= count)) {
            throw new IndexOutOfBoundsException();
        }
        int[] newArray = new int[toIndex - fromIndex];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = data[fromIndex];
            fromIndex++;
        }

        return newArray;
    }

    // Este método inverte o conteúdo da lista.
    public void reverse() {
        int aux = 0;
        int j = count - 1;
        for (int i = 0; i < count / 2; i++) {
            aux = data[i];
            data[i] = data[j];
            data[j] = aux;
            j--;
        }
    }

    // Este método conta o número de ocorrências do elemento passado como parâmetro na lista, retornando este valor.
    public int contaOcorrencias(int element) {
        int contador = 0;
        for (int i = 0; i < count; i++) {
            if (data[i] == element) contador++;
        }
        return contador;
    }

    // addFirst (que adiciona um elemento no início da lista)
    public void addFirst(int element) {
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        for (int i = count; i > 0; i--) {
            data[i] = data[i - 1];
        }
        data[0] = element;
        count++;
    }

    // removeFirst (que remove o primeiro elemento da lista) para esta classe.
    public int removeFirst() {
        if (isEmpty()) {            throw new IndexOutOfBoundsException();        }

        int aux = data[0];

        for (int i = 0; i < count - 1; i++) {
            data[i] = data[i + 1];
        }

        data[count - 1] = null;
        count--;

        if (count <= data.length / 4) {
            setCapacity(data.length / 2);
            System.out.println("Nova capacidade setada para " + (data.length / 2));
        }

        return aux;
    }

    // Considere que duas instâncias de ListArrayOfInteger foram criadas e inicializadas com alguns valores aleatórios, e
    // apresente o algoritmo necessário para descobrir e mostrar qual o maior valor que está armazenado nas duas listas
    // simultaneamente. Qual é a notação O para este algoritmo?
    public int achaMaior (ListArrayOfInteger l1, ListArrayOfInteger l2){
        int maior = Integer.MIN_VALUE;

        for (int i=0; i<l1.size(); i++){
            int valor = l1.get(i);
            if (valor > maior && l2.contains(valor)) maior = valor;
        }

        return maior;
    }

}