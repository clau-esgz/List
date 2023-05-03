package uaslp.objetos.list.linkedlist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

public class LinkedListTest {
    @Test
    public void whenListIsCreated_thenItIsEmpty() {

        LinkedList<String> list = new LinkedList<>();

        Assertions.assertTrue(list.isEmpty());
        Assertions.assertEquals(0,list.getSize());
    }
    @Test
    public void givenAnEmptyList_whenAddAtTail_thenElementIsInserted() throws NotNullAllowedException,BadIndexException {
        //inicialización
        LinkedList<String> list = new LinkedList<>();
        //Ejecución
        list.addAtTail("1");
        //validción
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenANonEmptyList_whenAddAtTail_thenElementIsInserted() throws NotNullAllowedException,BadIndexException{
        //inicializacion
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("1");
        //Ejecución
        list.addAtTail("2");
        //validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertEquals("2",list.getAt(1));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAnEmptyList_whenAddAtFront_thenElementIsInserted() throws NotNullAllowedException,BadIndexException {
        //inicialización
        LinkedList<String> list = new LinkedList<>();
        //Ejecución
        list.addAtFront("1");
        //validción
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenANonEmptyList_whenAddAtFront_thenElementIsInserted() throws NotNullAllowedException,BadIndexException{
        //inicializacion
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("1");
        //Ejecución
        list.addAtFront("2");
        //validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertEquals("1",list.getAt(1));
        Assertions.assertEquals("2",list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }

@Test
public void givenAList_whenAddAtTailANullValue_thenExceptionIsThrown() {
    //Inicialización
    LinkedList<String> list = new LinkedList<>();
    //  Ejecución
    Assertions.assertThrows(NotNullAllowedException.class, () -> list.addAtTail(null));
    //validacion
    Assertions.assertEquals(0, list.getSize());
    Assertions.assertTrue(list.isEmpty());
}
    @Test
    public void givenAList_whenAddAtFrontANullValue_thenExceptionIsThrown() {
        //Inicialización
        LinkedList<String> list = new LinkedList<>();
        //  Ejecución
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.addAtFront(null));
        //validacion
        Assertions.assertEquals(0, list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void givenAList_whenRemoveAWrongIndex_thenExceptionIsThrown(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();
        //Ejecución
        Assertions.assertThrows(BadIndexException.class,()->list.remove(3));
        //Validación
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void givenAListWithData_whenRemoveAWrongIndex_thenExceptionIsThrown()throws NotNullAllowedException{
        //Inicialización
        LinkedList<String> list = new LinkedList<>();
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
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        //Ejecución
        list.remove(0);
        //Validación
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void givenAListWith3Elements_whenRemoveAtHead_thenElementIsRemoved() throws BadIndexException,NotNullAllowedException{
        //Inicialización
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");
        //Ejecución
        list.remove(0);
        //Validación
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void givenAListWith3Elements_whenRemoveAtMiddle_thenElementIsRemoved() throws BadIndexException,NotNullAllowedException{
        //Inicialización
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");
        //Ejecución
        list.remove(1);
        //Validación
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAListWith3Elements_whenRemoveAtTail_thenElementIsRemoved() throws BadIndexException,NotNullAllowedException{
        //Inicialización
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");
        //Ejecución
        list.remove(2);
        //Validación
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAListWithElements_whenRemoveAllWithValue_theHeadIsRemoved()throws NotNullAllowedException{
      // Inicialización
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("1");
        list.addAtTail("2");
        list.addAtFront("0");
        list.addAtTail("3");
     //Ejecución
        list.removeAllWithValue("0");
        //Validación
        Assertions.assertEquals(3,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAListWithElements_whenRemoveAllWithValue_theTailIsRemoved()throws NotNullAllowedException{
        // Inicialización
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("1");
        list.addAtTail("2");
        list.addAtFront("0");
        list.addAtTail("3");
        //Ejecución
        list.removeAllWithValue("3");
        //Validación
        Assertions.assertEquals(3,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAListWithElements_whenRemoveAllWithValue_theElementInTheMiddleIsRemoved()throws NotNullAllowedException, BadIndexException{
        // Inicialización
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("1");
        list.addAtTail("2");
        list.addAtFront("0");
        list.addAtTail("3");
        //Ejecución
        list.removeAllWithValue("1");
        //Validación
        Assertions.assertEquals(3,list.getSize());
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals("0",list.getAt(0));
        Assertions.assertEquals("2",list.getAt(1));
        Assertions.assertEquals("3",list.getAt(2));
    }
    @Test
    public void givenAListWithElements_whenRemoveAllWithValue_theOnlyElementIsRemoved()throws NotNullAllowedException{
        // Inicialización
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("10");
        //Ejecución
        list.removeAllWithValue("10");
        //Validación
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());

    }
    @Test
    public void givenAListWithElements_whenRemoveAll_AllElementsIsRemoved()throws NotNullAllowedException{
        // Inicialización
        LinkedList<String> list = new LinkedList<>();
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
    @Test //remplazar datos, tambien probar las excepciones
    public void givenAListWithElements_whenSetAt_theElementIsRemplaced()throws NotNullAllowedException, BadIndexException{
        // Inicialización
        LinkedList<String> list = new LinkedList<>();
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
    @Test //remplazar datos, tambien probar las excepciones
    public void givenAListWithElements_whenSetAt_givenABadIndex_thenExceptionIsThrown()throws NotNullAllowedException, BadIndexException{
        // Inicialización
        LinkedList<String> list = new LinkedList<>();
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
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("1");
        list.addAtTail("2");
        Iterator<Object> iteratorList = list.getIterator();
        while (iteratorList.hasNext()) {
            System.out.println("  " + iteratorList.next());
        }
    }
    }




