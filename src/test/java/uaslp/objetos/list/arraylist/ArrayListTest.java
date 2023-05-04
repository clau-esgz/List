package uaslp.objetos.list.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;
import uaslp.objetos.list.linkedlist.LinkedList;

public class ArrayListTest {
    @Test
    public void whenArrayListIsCreated_thenItIsEmpty() {

        ArrayList<String> list = new ArrayList<>();
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void whenArrayListIsCreated_thenElementsAreAdded_thenTheListItIsNotEmpty()throws NotNullAllowedException{

        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("4");
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(1,list.getSize());
    }
    @Test
    public void givenAnEmptyList_whenAddAtFront_thenElementIsInserted() throws NotNullAllowedException,BadIndexException{
        //Inicialización
        ArrayList<String> list = new ArrayList<>();
        //Ejecucion
        list.addAtFront("1");
        //validacion
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(1,list.getSize());

    }
    @Test
    public void givenAnNotEmptyList_whenAddAtFront_thenElementIsInserted() throws NotNullAllowedException,BadIndexException{
        //Inicialización
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("4");
        list.addAtFront("3");
        list.addAtFront("2");
        list.addAtFront("1");
        //Ejecucion
        list.addAtFront("0");
        //validacion
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(5,list.getSize());
        Assertions.assertEquals("0",list.getAt(0));
        Assertions.assertEquals("1",list.getAt(1));
        Assertions.assertEquals("2",list.getAt(2));
        Assertions.assertEquals("3",list.getAt(3));
        Assertions.assertEquals("4",list.getAt(4));
    }
    @Test
    public void givenAnEmptyList_whenAddAtTail_thenElementIsInserted() throws NotNullAllowedException{
        //Inicialización
        ArrayList<String> list = new ArrayList<>();
        //Ejecucion
        list.addAtTail("1");
        //validacion
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(1,list.getSize());
    }
    @Test
    public void givenAnNotEmptyList_whenAddAtTail_thenElementIsInserted() throws NotNullAllowedException{
        //Inicialización
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("1");
        list.addAtTail("2");
        list.addAtTail("3");
        //Ejecucion
        list.addAtTail("4");
        //validacion
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(4,list.getSize());
    }
    @Test
    public void givenAList_whenAddAtTailANullValue_thenExceptionIsThrown(){
        //Inicialización
        ArrayList<String> list = new ArrayList<>();
        //  Ejecución
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.addAtTail(null));
        //validacion
        Assertions.assertEquals(0, list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void givenAList_whenAddAtFrontANullValue_thenExceptionIsThrown() {
        //Inicialización
        ArrayList<String> list = new ArrayList<>();
        //  Ejecución
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.addAtFront(null));
        //validacion
        Assertions.assertEquals(0, list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void givenAList_whenRemoveAWrongIndex_thenExceptionIsThrown(){
        //Inicialización
        ArrayList<String> list = new ArrayList<>();
        //Ejecución
        Assertions.assertThrows(BadIndexException.class,()->list.remove(3));
        //Validación
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void givenAListWithData_whenRemoveAWrongIndex_thenExceptionIsThrown()throws NotNullAllowedException{
        //Inicialización
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("10");
        list.addAtFront("5");
        //Ejecución
        Assertions.assertThrows(BadIndexException.class,()->list.remove(3));
        //Validación
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAListWithElement_whenRemove_thenElementIsRemoved() throws BadIndexException, NotNullAllowedException{
        //Inicialización
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("10");
        //Ejecución
        list.remove(0);
        //Validación
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
@Test
    public void givenAListWithElement_RemoveTheValueOfAGivenIndex() throws NotNullAllowedException,BadIndexException{
        //Inicializacion
    ArrayList<String> list = new ArrayList<>();
    list.addAtTail("1");
    list.addAtTail("2");
    list.addAtTail("3");
    list.addAtFront("0");
    //Ejecucion
    list.remove(2);
    list.remove(0);
    //Validacion
    Assertions.assertEquals(2,list.getSize());
    Assertions.assertFalse(list.isEmpty());
}
    @Test
    public void givenAListWithElements_whenRemoveAllWithValue_theElementIsRemoved()throws NotNullAllowedException{
        // Inicialización
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("2");
        list.addAtFront("1");
        list.addAtFront("0");
        //Ejecución
        list.removeAllWithValue("0");
        //Validación
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAListWithElements_whenRemoveAll_AllElementsIsRemoved()throws NotNullAllowedException{
        // Inicialización
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("1");
        list.addAtTail("2");
        list.addAtFront("0");
        list.addAtTail("3");
        //Ejecución
        list.removeAll();
        //Validación
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void givenAListWithElements_whenSetAt_theElementIsRemplaced()throws NotNullAllowedException, BadIndexException{
        // Inicialización
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("1");
        list.addAtTail("2");
        //Ejecución
        list.setAt(0,"2");
        list.setAt(1,"1");
        //Validación
        Assertions.assertEquals("2",list.getAt(0));
        Assertions.assertEquals("1",list.getAt(1));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAListWithElements_whenSetAt_givenABadIndex_thenExceptionIsThrown()throws NotNullAllowedException, BadIndexException{
        // Inicialización
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("1");
        list.addAtTail("2");
        //Ejecución
        Assertions.assertThrows(BadIndexException.class,()->list.setAt(3,"1"));
        //Validación
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertEquals("2",list.getAt(1));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAListWithElements_loopThroughListUsingIterator() throws BadIndexException, NotNullAllowedException {
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("1");
        list.addAtTail("2");
        Iterator<String> iteratorList = list.getIterator();
        while (iteratorList.hasNext()) {
            System.out.println("  " + iteratorList.next());
        }
    }
    @Test
    public void givenAListWithElements_getTheLengthOfTheArray()throws NotNullAllowedException{
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("1");
        list.addAtTail("2");
        list.addAtTail("3");
        list.addAtFront("0");
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(4,list.getLength());
    }
}
