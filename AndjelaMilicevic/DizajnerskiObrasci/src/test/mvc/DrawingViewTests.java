package mvc;

import static org.mockito.Mockito.*;
import org.junit.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import geometry.Point;

public class DrawingViewTests {
	private DrawingModel model;
	private DrawingView view;
	private Point point;
	private Graphics2D graphics;

	@Before
	public void setUp() {
		model = new DrawingModel();
		view = new DrawingView();
		point = mock(Point.class);
		model.addShape(point);
		view.setModel(model);
		graphics = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB).createGraphics();
	}

	@Test
	public void testPaint() {
		view.paint(graphics);
		verify(point).draw(graphics);
	}
}