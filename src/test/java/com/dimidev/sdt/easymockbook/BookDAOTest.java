package com.dimidev.sdt.easymockbook;




import com.dimidev.sdt.easymockbook.BookDAO;
import com.dimidev.sdt.easymockbook.IConnection;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BookDAOTest {

    private BookDAO bookDAO;
    private IConnection mockedConnectionObject;
    private Book book;


    @Before
    public void setUp() throws Exception {
        book = new Book();
        mockedConnectionObject = createMock(IConnection.class);
        bookDAO = new BookDAO(mockedConnectionObject);

    }


    @Test
    public void testInsertBookRosy() {
        expect(mockedConnectionObject.insert(book)).andReturn(true);
        replay(mockedConnectionObject);

        assertTrue(bookDAO.insert(book));

        verify(mockedConnectionObject);

    }

    @Test
    public void testInsertBookNonRosy() {
        expect(mockedConnectionObject.insert(book)).andReturn(false);
        replay(mockedConnectionObject);

        assertFalse(bookDAO.insert(book));

        verify(mockedConnectionObject);

    }

    @Test
    public void testSelectByID() {
        int i = 5;
        expect(mockedConnectionObject.selectByID(i)).andReturn(book);
        replay(mockedConnectionObject);

        assertEquals(book, bookDAO.selectByID(i));

        verify(mockedConnectionObject);

    }

    @Test
    public void testSelectByNonExistingID() {
        int i = 5;
        expect(mockedConnectionObject.selectByID(i)).andReturn(null);
        replay(mockedConnectionObject);

        assertNull(bookDAO.selectByID(i));

        verify(mockedConnectionObject);

    }
}
