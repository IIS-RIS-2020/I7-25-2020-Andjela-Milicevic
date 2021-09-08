package mvc.controller;

import command.*;
import geometry.*;
import java.awt.Color;
import java.util.Iterator;
import mvc.DrawingModel;

class LoggerController {
	private DrawingModel model;
	private DrawingController controller;
	private Point point;

	LoggerController(DrawingModel model, DrawingController controller) {
		this.model = model;
		this.controller = controller;
	}

	Command makeChangeLayerCommand(String[] log) {
		switch (log[1]) {

		case "Rectangle": {
			createChangeLayerCommand(makeRectangle(log, 0), Integer.parseInt(log[27]));
		}

		case "Hexagon": {
			createChangeLayerCommand(makeHexagon(log, 0), Integer.parseInt(log[24]));
		}

		case "Donut": {
			createChangeLayerCommand(makeDonut(log, 0), Integer.parseInt(log[27]));
		}

		case "Circle": {
			createChangeLayerCommand(makeCircle(log, 0), Integer.parseInt(log[24]));
		}

		case "Line": {
			createChangeLayerCommand(makeLine(log, 0), Integer.parseInt(log[19]));
		}

		case "Point": {
			createChangeLayerCommand(makePoint(log, 0), Integer.parseInt(log[14]));
		}
		}

		return null;
	}

	private Command createChangeLayerCommand(Shape shape, int index) {
		Iterator<Shape> iterator = model.getShapes().iterator();

		while (iterator.hasNext()) {
			Shape shapeFromList = (iterator.next());

			if (shapeFromList.equals(shape)) {
				shape = shapeFromList;
				break;
			}
		}

		Command cmdChangeLayer = new CmdChangeLayer(point, model, index);
		return cmdChangeLayer;
	}

	Command makeDeleteCommand(String[] splits) {
		switch (splits[1]) {
		case "Rectangle": {
			return createDeleteCommand(makeRectangle(splits, 0));
		}

		case "Hexagon": {
			return createDeleteCommand(makeHexagon(splits, 0));
		}

		case "Donut": {
			return createDeleteCommand(makeDonut(splits, 0));
		}

		case "Circle": {
			return createDeleteCommand(makeCircle(splits, 0));
		}

		case "Line": {
			return createDeleteCommand(makeLine(splits, 0));
		}

		case "Point": {
			return createDeleteCommand(makePoint(splits, 0));
		}
		}

		return null;
	}

	private Command createDeleteCommand(Shape shape) {
		Iterator<Shape> iterator = model.getShapes().iterator();

		while (iterator.hasNext()) {
			Shape shapeFromList = iterator.next();

			if (shapeFromList.equals(shape)) {
				shape = shapeFromList;
				break;
			}
		}

		Command cmdDelete = new CmdDelete(shape, model);
		return cmdDelete;
	}

	Command makeModifyCommand(String[] splits) {
		switch (splits[1]) {

		case "Rectangle": {
			createModifyRectangleCommand(splits);
		}

		case "Hexagon": {
			createModifyHexagonCommand(splits);
		}

		case "Donut": {
			createModifyDonutCommand(splits);
		}

		case "Circle": {
			createModifyCircleCommand(splits);
		}
		case "Line": {
			createModifyLineCommand(splits);
		}

		case "Point": {
			createModifyPointCommand(splits);
		}
		}

		return null;
	}

	private Command createModifyRectangleCommand(String[] splits) {
		Rectangle oldRect = makeRectangle(splits, 0);
		Iterator<Shape> iterator = model.getShapes().iterator();

		while (iterator.hasNext()) {
			Shape shapeFromList = (iterator.next());

			if (shapeFromList.equals(oldRect)) {
				oldRect = (Rectangle) shapeFromList;
				break;
			}
		}

		Rectangle newRect = makeRectangle(splits, 25);
		Command cmd = new CmdModifyRectangle(oldRect, newRect);
		controller.addRemoveSelectedExecute(cmd);
		return cmd;
	}

	private Command createModifyHexagonCommand(String[] splits) {
		HexagonAdapter oldHex = makeHexagon(splits, 0);
		Iterator<Shape> iterator = model.getShapes().iterator();

		while (iterator.hasNext()) {
			Shape shapeFromList = (iterator.next());

			if (shapeFromList.equals(oldHex)) {
				oldHex = (HexagonAdapter) shapeFromList;
				break;
			}
		}

		HexagonAdapter newHex = makeHexagon(splits, 22);
		Command cmd = new CmdModifyHexagon(oldHex, newHex);
		controller.addRemoveSelectedExecute(cmd);
		return cmd;
	}

	private Command createModifyDonutCommand(String[] splits) {
		Donut oldDonut = makeDonut(splits, 0);
		Iterator<Shape> iterator = model.getShapes().iterator();

		while (iterator.hasNext()) {
			Shape shapeFromList = (iterator.next());

			if (shapeFromList.equals(oldDonut)) {
				oldDonut = (Donut) shapeFromList;
				break;
			}
		}

		Donut newDonut = makeDonut(splits, 25);
		Command cmd = new CmdModifyDonut(oldDonut, newDonut);
		controller.addRemoveSelectedExecute(cmd);
		return cmd;
	}

	private Command createModifyCircleCommand(String[] splits) {
		Circle oldCircle = makeCircle(splits, 0);
		Iterator<Shape> iterator = model.getShapes().iterator();

		while (iterator.hasNext()) {
			Shape shapeFromList = (iterator.next());
			if (shapeFromList.equals(oldCircle)) {
				oldCircle = (Circle) shapeFromList;
				break;
			}
		}

		Circle newCircle = makeCircle(splits, 22);
		Command cmd = new CmdModifyCircle(oldCircle, newCircle);
		controller.addRemoveSelectedExecute(cmd);
		return cmd;
	}

	private Command createModifyLineCommand(String[] splits) {
		Line oldLine = makeLine(splits, 0);
		Iterator<Shape> iterator = model.getShapes().iterator();

		while (iterator.hasNext()) {
			Shape shapeFromList = (iterator.next());

			if (shapeFromList.equals(oldLine)) {
				oldLine = (Line) shapeFromList;
				break;
			}
		}

		Line newLine = makeLine(splits, 17);
		Command cmd = new CmdModifyLine(oldLine, newLine);
		controller.addRemoveSelectedExecute(cmd);
		return cmd;
	}

	private Command createModifyPointCommand(String[] splits) {
		Point oldPoint = makePoint(splits, 0);

		Iterator<Shape> iterator = model.getShapes().iterator();

		while (iterator.hasNext()) {
			Shape shapeFromList = (iterator.next());

			if (shapeFromList.equals(oldPoint)) {
				oldPoint = (Point) shapeFromList;
				break;
			}
		}

		Point newPoint = makePoint(splits, 12);
		Command cmd = new CmdModifyPoint(oldPoint, newPoint);
		controller.addRemoveSelectedExecute(cmd);
		return cmd;
	}

	Command makeAddCommand(String[] splits) {
		switch (splits[1]) {

		case "Rectangle": {
			Command cmdAdd = new CmdAdd(makeRectangle(splits, 0), model);
			return cmdAdd;
		}

		case "Hexagon": {
			Command cmdAdd = new CmdAdd(makeHexagon(splits, 0), model);
			return cmdAdd;
		}

		case "Donut": {
			Command cmdAdd = new CmdAdd(makeDonut(splits, 0), model);
			return cmdAdd;
		}

		case "Circle": {
			Command cmdAdd = new CmdAdd(makeCircle(splits, 0), model);
			return cmdAdd;
		}

		case "Line": {
			Command cmdAdd = new CmdAdd(makeLine(splits, 0), model);
			return cmdAdd;
		}

		case "Point": {
			Command cmdAdd = new CmdAdd(makePoint(splits, 0), model);
			return cmdAdd;
		}
		}

		return null;
	}

	private Rectangle makeRectangle(String[] splits, int diff) {
		setPoint(splits, diff);
		int width = Integer.parseInt(splits[7 + diff]);
		int height = Integer.parseInt(splits[10 + diff]);
		Color borderColor = new Color(Integer.parseInt(splits[13 + diff]));
		Color areaColor = new Color(Integer.parseInt(splits[17 + diff]));
		boolean selected;

		if (splits[20 + diff].equals("selected")) {
			selected = true;
		} else {
			selected = false;
		}

		Rectangle rectangle = new Rectangle(point, height, width);
		setColorsAndSelection(rectangle, borderColor, areaColor, selected);
		return rectangle;
	}

	private HexagonAdapter makeHexagon(String[] splits, int diff) {
		setPoint(splits, diff);
		int radius = Integer.parseInt(splits[7 + diff]);
		Color borderColor = new Color(Integer.parseInt(splits[10 + diff]));
		Color areaColor = new Color(Integer.parseInt(splits[14 + diff]));
		boolean selected;

		if (splits[17 + diff].equals("selected")) {
			selected = true;
		} else {
			selected = false;
		}

		HexagonAdapter hexagon = new HexagonAdapter(point, radius);
		setColorsAndSelection(hexagon, borderColor, areaColor, selected);
		return hexagon;
	}

	private Donut makeDonut(String[] splits, int diff) {
		setPoint(splits, diff);
		int outerRadius = Integer.parseInt(splits[7 + diff]);
		int innerRadius = Integer.parseInt(splits[10 + diff]);
		Color borderColor = new Color(Integer.parseInt(splits[13 + diff]));
		Color fillColor = new Color(Integer.parseInt(splits[17 + diff]));
		boolean selected;

		if (splits[20 + diff].equals("selected")) {
			selected = true;
		} else {
			selected = false;
		}

		Donut donut = new Donut(point, outerRadius, innerRadius);
		setColorsAndSelection(donut, borderColor, fillColor, selected);
		return donut;
	}

	private Circle makeCircle(String[] splits, int diff) {
		setPoint(splits, diff);
		int radius = Integer.parseInt(splits[7 + diff]);
		Color borderColor = new Color(Integer.parseInt(splits[10 + diff]));
		Color fillColor = new Color(Integer.parseInt(splits[14 + diff]));
		boolean selected;

		if (splits[17 + diff].equals("selected")) {
			selected = true;
		} else {
			selected = false;
		}

		Circle circle = new Circle(point, radius);
		setColorsAndSelection(circle, borderColor, fillColor, selected);
		return circle;
	}

	private Line makeLine(String[] splits, int diff) {
		int xCoordinateStart = Integer.parseInt(splits[3 + diff]);
		int yCoordinateStart = Integer.parseInt(splits[4 + diff]);
		int xCoordinateEnd = Integer.parseInt(splits[7 + diff]);
		int yCoordinateEnd = Integer.parseInt(splits[8 + diff]);
		Point startPoint = new Point(xCoordinateStart, yCoordinateStart);
		Point endPoint = new Point(xCoordinateEnd, yCoordinateEnd);
		Color borderColor = new Color(Integer.parseInt(splits[11 + diff]));
		boolean selected;

		if (splits[14 + diff].equals("selected")) {
			selected = true;
		} else {
			selected = false;
		}

		Line line = new Line(startPoint, endPoint);
		line.setSelected(selected);
		line.setBorderColor(borderColor);
		return line;
	}

	private Point makePoint(String[] splits, int diff) {
		int xCoordinate = Integer.parseInt(splits[3 + diff]);
		int yCoordinate = Integer.parseInt(splits[4 + diff]);
		Color border = new Color(Integer.parseInt(splits[7 + diff]));
		boolean selected;

		if (splits[9 + diff].equals("selected")) {
			selected = true;
		} else {
			selected = false;
		}

		Point point = new Point(xCoordinate, yCoordinate);
		point.setSelected(selected);
		point.setBorderColor(border);
		return point;
	}

	private void setPoint(String[] splits, int diff) {
		int xCoordinate = Integer.parseInt(splits[3 + diff]);
		int yCoordinate = Integer.parseInt(splits[4 + diff]);
		point = new Point(xCoordinate, yCoordinate);
	}

	private void setColorsAndSelection(Shape shape, Color borderColor, Color areaColor, boolean selected) {
		shape.setBorderColor(borderColor);
		shape.setSelected(selected);

		if (shape instanceof AreaShape) {
			((AreaShape) shape).setAreaColor(areaColor);
		}
	}
}