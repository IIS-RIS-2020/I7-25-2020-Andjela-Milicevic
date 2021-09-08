package mvc.controller;

import command.*;
import dialogs.*;
import geometry.*;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import mvc.DrawingModel;
import observer.SelectedShapes;

public class ModifyShapeController {
	private DrawingController controller;
	private DrawingModel model;
	private SelectedShapes selectedShapes;
	private Shape selectedShape;

	ModifyShapeController(DrawingController controller, DrawingModel model, SelectedShapes selectedShapes) {
		this.controller = controller;
		this.model = model;
		this.selectedShapes = selectedShapes;
	}

	void modify(MouseEvent event, Point point) {
		point = null;
		Iterator<Shape> iterator = model.getShapes().iterator();

		while (iterator.hasNext()) {
			Shape shapeFromList = (iterator.next());

			if (shapeFromList.contains(event.getX(), event.getY())) {
				this.selectedShape = shapeFromList;
			}
		}

		if (selectedShape != null) {
			if (!selectedShape.isSelected()) {
				modifySelectedShape(selectedShape, true);
			} else {
				modifySelectedShape(selectedShape, false);
			}

			selectedShape = null;
		}
	}

	private void modifySelectedShape(Shape selectedShape, boolean setSelected) {
		if (selectedShape instanceof Point) {
			executeModifyPointCommand(setSelected);
		} else if (selectedShape instanceof Line) {
			executeModifyLineCommand(setSelected);
		} else if (selectedShape instanceof Donut) {
			executeModifyDonutCommand(setSelected);
		} else if (selectedShape instanceof Rectangle) {
			executeModifyRectangleCommand(setSelected);
		} else if (selectedShape instanceof Circle) {
			executeModifyCircleCommand(setSelected);
		} else if (selectedShape instanceof HexagonAdapter) {
			executeModifyHexagonCommand(setSelected);
		}
	}

	private void executeModifyPointCommand(boolean setSelected) {
		Point newPoint = new Point();
		newPoint.setFields(selectedShape);
		newPoint.setSelected(setSelected);
		CmdModifyPoint commandModifyPoint = new CmdModifyPoint(((Point) selectedShape), newPoint);
		controller.addRemoveSelectedExecute(commandModifyPoint);
		controller.executeCommand(commandModifyPoint);
	}

	private void executeModifyLineCommand(boolean setSelected) {
		Line newLine = new Line();
		newLine.setFields(selectedShape);
		newLine.setSelected(setSelected);
		CmdModifyLine commandModifyLine = new CmdModifyLine(((Line) selectedShape), newLine);
		controller.addRemoveSelectedExecute(commandModifyLine);
		controller.executeCommand(commandModifyLine);
	}

	private void executeModifyRectangleCommand(boolean setSelected) {
		Rectangle newRect = new Rectangle();
		newRect.setFields(selectedShape);
		newRect.setSelected(setSelected);
		CmdModifyRectangle commandModifyRectangle = new CmdModifyRectangle(((Rectangle) selectedShape), newRect);
		controller.addRemoveSelectedExecute(commandModifyRectangle);
		controller.executeCommand(commandModifyRectangle);
	}

	private void executeModifyDonutCommand(boolean setSelected) {
		Donut newDonut = new Donut();
		newDonut.setFields(((Donut) selectedShape));
		newDonut.setSelected(setSelected);
		CmdModifyDonut commandModifyDonut = new CmdModifyDonut(((Donut) selectedShape), newDonut);
		controller.addRemoveSelectedExecute(commandModifyDonut);
		controller.executeCommand(commandModifyDonut);
	}

	private void executeModifyCircleCommand(boolean setSelected) {
		Circle newCircle = new Circle();
		newCircle.setFields(selectedShape);
		newCircle.setSelected(setSelected);
		CmdModifyCircle commandModifyCircle = new CmdModifyCircle(((Circle) selectedShape), newCircle);
		controller.addRemoveSelectedExecute(commandModifyCircle);
		controller.executeCommand(commandModifyCircle);
	}

	private void executeModifyHexagonCommand(boolean setSelected) {
		HexagonAdapter newHex = new HexagonAdapter();
		newHex.setFields(selectedShape);
		newHex.setSelected(setSelected);
		CmdModifyHexagon commandModifyHexagon = new CmdModifyHexagon(((HexagonAdapter) selectedShape), newHex);
		controller.addRemoveSelectedExecute(commandModifyHexagon);
		controller.executeCommand(commandModifyHexagon);
	}

	public void clickedModify() {
		if (selectedShapes.getNumberOfSelectedShapes() == 1) {
			if (selectedShapes.getSelectedShapeByIndex(0) instanceof Point) {
				modifyPoint();
			} else if (selectedShapes.getSelectedShapeByIndex(0) instanceof Line) {
				modifyLine();
			} else if (selectedShapes.getSelectedShapeByIndex(0) instanceof Rectangle) {
				modifyRectangle();
			} else if (selectedShapes.getSelectedShapeByIndex(0) instanceof Donut) {
				modifyDonut();
			} else if (selectedShapes.getSelectedShapeByIndex(0) instanceof Circle) {
				modifyCircle();
			} else if (selectedShapes.getSelectedShapeByIndex(0) instanceof HexagonAdapter) {
				modifyHexagon();
			}
		}
	}

	private void modifyPoint() {
		Point point = (Point) selectedShapes.getSelectedShapeByIndex(0);
		PointDialog dialogPoint = new PointDialog();
		dialogPoint.setTxtXcoordinate(Integer.toString(point.getXcoordinate()));
		dialogPoint.setTxtYcoordinate(Integer.toString(point.getYcoordinate()));
		dialogPoint.setBorderColor(point.getBorderColor());
		dialogPoint.setVisible(true);

		if (dialogPoint.isOk()) {
			Point newPoint = new Point();
			newPoint.setXcoordinate(Integer.parseInt(dialogPoint.getXcoordinate()));
			newPoint.setYcoordinate(Integer.parseInt(dialogPoint.getYcoordinate()));
			newPoint.setBorderColor(dialogPoint.getBorderColor());
			newPoint.setSelected(true);
			CmdModifyPoint cmdModify = new CmdModifyPoint(point, newPoint);
			controller.addRemoveSelectedExecute(cmdModify);
			controller.executeCommand(cmdModify);
		}
	}

	private void modifyLine() {
		Line line = (Line) selectedShapes.getSelectedShapeByIndex(0);
		LineDialog dialogLine = new LineDialog();
		dialogLine.setTxtXcoordinate(Integer.toString(line.getStartPoint().getXcoordinate()));
		dialogLine.setTxtYcoordinate(Integer.toString(line.getStartPoint().getYcoordinate()));
		dialogLine.setTxtEndX(Integer.toString(line.getEndPoint().getXcoordinate()));
		dialogLine.setTxtEndY(Integer.toString(line.getEndPoint().getYcoordinate()));
		dialogLine.setBorderColor(line.getBorderColor());
		dialogLine.setVisible(true);

		if (dialogLine.isOk()) {
			Line newLine = new Line();

			newLine.setStartPoint(new Point(Integer.parseInt(dialogLine.getXcoordinate()),
					Integer.parseInt(dialogLine.getYcoordinate())));

			newLine.setEndPoint(
					new Point(Integer.parseInt(dialogLine.getTxtEndX()), Integer.parseInt(dialogLine.getTxtEndY())));

			newLine.setBorderColor(dialogLine.getBorderColor());
			newLine.setSelected(true);
			CmdModifyLine cmdModify = new CmdModifyLine(line, newLine);
			controller.addRemoveSelectedExecute(cmdModify);
			controller.executeCommand(cmdModify);
		}
	}

	private void modifyRectangle() {
		Rectangle rectangle = (Rectangle) selectedShapes.getSelectedShapeByIndex(0);
		RectangleDialog dialogRectangle = new RectangleDialog();
		dialogRectangle.setTxtXcoordinate((Integer.toString(rectangle.getUpperLeftPoint().getXcoordinate())));
		dialogRectangle.setTxtYcoordinate(Integer.toString(rectangle.getUpperLeftPoint().getYcoordinate()));
		dialogRectangle.setTxtHeight(Integer.toString(rectangle.getHeight()));
		dialogRectangle.setTxtWidth(Integer.toString(rectangle.getWidth()));
		dialogRectangle.setAreaColor(rectangle.getAreaColor());
		dialogRectangle.setBorderColor(rectangle.getBorderColor());
		dialogRectangle.setVisible(true);

		if (dialogRectangle.isOk()) {
			Rectangle newRect = new Rectangle();

			newRect.setUpperLeftPoint(new Point(Integer.parseInt(dialogRectangle.getXcoordinate()),
					Integer.parseInt(dialogRectangle.getYcoordinate())));

			newRect.setHeight(Integer.parseInt(dialogRectangle.getTxtHeight()));
			newRect.setWidth(Integer.parseInt(dialogRectangle.getTxtWidth()));
			newRect.setAreaColor(dialogRectangle.getAreaColor());
			newRect.setBorderColor(dialogRectangle.getBorderColor());
			newRect.setSelected(true);
			CmdModifyRectangle cmdModify = new CmdModifyRectangle(rectangle, newRect);
			controller.addRemoveSelectedExecute(cmdModify);
			controller.executeCommand(cmdModify);
		}
	}

	private void modifyDonut() {
		Donut donut = (Donut) selectedShapes.getSelectedShapeByIndex(0);
		DonutDialog dialogDonut = new DonutDialog();
		dialogDonut.setTxtXcoordinate(Integer.toString(donut.getCenter().getXcoordinate()));
		dialogDonut.setTxtYcoordinate(Integer.toString(donut.getCenter().getYcoordinate()));
		dialogDonut.setTxtInnerRadius(Integer.toString(donut.getInnerRadius()));
		dialogDonut.setTxtRadius(Integer.toString(donut.getRadius()));
		dialogDonut.setAreaColor(donut.getAreaColor());
		dialogDonut.setBorderColor(donut.getBorderColor());
		dialogDonut.setVisible(true);

		if (dialogDonut.isOk()) {
			Donut newDonut = new Donut();

			newDonut.setCenter(new Point(Integer.parseInt(dialogDonut.getXcoordinate()),
					Integer.parseInt(dialogDonut.getYcoordinate())));

			newDonut.setRadius(Integer.parseInt(dialogDonut.getTxtRadius()));
			newDonut.setInnerRadius(Integer.parseInt(dialogDonut.getTxtInnerRadius()));
			newDonut.setBorderColor(dialogDonut.getBorderColor());
			newDonut.setAreaColor(dialogDonut.getAreaColor());
			newDonut.setSelected(true);
			CmdModifyDonut cmdModify = new CmdModifyDonut(donut, newDonut);
			controller.addRemoveSelectedExecute(cmdModify);
			controller.executeCommand(cmdModify);
		}
	}

	private void modifyCircle() {
		Circle circle = (Circle) selectedShapes.getSelectedShapeByIndex(0);
		CircleDialog dialogCircle = new CircleDialog();
		dialogCircle.setTxtXcoordinate(Integer.toString(circle.getCenter().getXcoordinate()));
		dialogCircle.setTxtYcoordinate(Integer.toString(circle.getCenter().getYcoordinate()));
		dialogCircle.setTxtRadius(Integer.toString(circle.getRadius()));
		dialogCircle.setAreaColor(circle.getAreaColor());
		dialogCircle.setBorderColor(circle.getBorderColor());
		dialogCircle.setVisible(true);

		if (dialogCircle.isOk()) {
			Circle newCircle = new Circle();

			newCircle.setCenter(new Point(Integer.parseInt(dialogCircle.getXcoordinate()),
					Integer.parseInt(dialogCircle.getYcoordinate())));

			newCircle.setRadius(Integer.parseInt(dialogCircle.getTxtRadius()));
			newCircle.setAreaColor(dialogCircle.getAreaColor());
			newCircle.setBorderColor(dialogCircle.getBorderColor());
			newCircle.setSelected(true);
			CmdModifyCircle cmdModify = new CmdModifyCircle(circle, newCircle);
			controller.addRemoveSelectedExecute(cmdModify);
			controller.executeCommand(cmdModify);
		}
	}

	private void modifyHexagon() {
		HexagonAdapter hexagon = (HexagonAdapter) selectedShapes.getSelectedShapeByIndex(0);
		HexagonDialog dialogHexagon = new HexagonDialog();
		dialogHexagon.setTxtXcoordinate(Integer.toString(hexagon.getCenter().getXcoordinate()));
		dialogHexagon.setTxtYcoordinate(Integer.toString(hexagon.getCenter().getYcoordinate()));
		dialogHexagon.setTxtRadius(Integer.toString(hexagon.getRadius()));
		dialogHexagon.setAreaColor(hexagon.getAreaColor());
		dialogHexagon.setBorderColor(hexagon.getBorderColor());
		dialogHexagon.setVisible(true);

		if (dialogHexagon.isOk()) {
			Point center = new Point(Integer.parseInt(dialogHexagon.getXcoordinate()),
					Integer.parseInt(dialogHexagon.getYcoordinate()));

			int radius = Integer.parseInt(dialogHexagon.getTxtRadius());
			HexagonAdapter newHex = new HexagonAdapter(center, radius);
			newHex.setAreaColor(dialogHexagon.getAreaColor());
			newHex.setBorderColor(dialogHexagon.getBorderColor());
			newHex.setSelected(true);
			CmdModifyHexagon cmdModify = new CmdModifyHexagon(hexagon, newHex);
			controller.addRemoveSelectedExecute(cmdModify);
			controller.executeCommand(cmdModify);
		}
	}
}