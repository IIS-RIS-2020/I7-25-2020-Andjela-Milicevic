package mvc.controller;

import dialogs.*;
import geometry.*;
import frame.DrawingFrame;
import java.awt.Color;
import java.awt.event.MouseEvent;
import command.CmdAdd;
import mvc.DrawingModel;

class AddShapeController {
	private DrawingModel model;
	private DrawingFrame frame;
	private DrawingController controller;
	private Point clickedPoint;
	private Color borderColor;
	private Color areaColor;

	AddShapeController(DrawingModel model, DrawingFrame frame, DrawingController drawingController, Point point,
			Color borderColor, Color areaColor) {
		this.model = model;
		this.frame = frame;
		controller = drawingController;
		clickedPoint = point;
		this.borderColor = borderColor;
		this.areaColor = areaColor;
	}

	void addPoint(MouseEvent event) {
		PointDialog dialogPoint = new PointDialog();
		dialogPoint.setTxtXcoordinate(Integer.toString(event.getX()));
		dialogPoint.setTxtYcoordinate(Integer.toString(event.getY()));
		dialogPoint.setTxtCoordinateXeditable(false);
		dialogPoint.setTxtCoordinateYeditable(false);
		dialogPoint.setVisible(true);

		if (dialogPoint.isOk()) {
			clickedPoint = new Point();
			clickedPoint.setXcoordinate(event.getX());
			clickedPoint.setYcoordinate(event.getY());
			clickedPoint.setBorderColor(getBorderColor(dialogPoint.getBorderColor()));
			CmdAdd cmdAdd = new CmdAdd(clickedPoint, model);
			controller.executeCommand(cmdAdd);
		}

		clickedPoint = null;
	}

	void addLine(MouseEvent event) {
		if (clickedPoint == null) {
			clickedPoint = new Point(event.getX(), event.getY());
		} else {
			Line line = new Line(clickedPoint, new Point(event.getX(), event.getY()));
			LineDialog dialogLine = new LineDialog();
			dialogLine.setTxtCoordinateXeditable(false);
			dialogLine.setTxtCoordinateYeditable(false);
			dialogLine.setTxtEndXeditable(false);
			dialogLine.setTxtEndYeditable(false);
			dialogLine.setTxtXcoordinate(Integer.toString(line.getStartPoint().getXcoordinate()));
			dialogLine.setTxtYcoordinate(Integer.toString(line.getStartPoint().getYcoordinate()));
			dialogLine.setTxtEndX(Integer.toString(line.getEndPoint().getXcoordinate()));
			dialogLine.setTxtEndY(Integer.toString(line.getEndPoint().getYcoordinate()));
			dialogLine.setVisible(true);

			if (dialogLine.isOk()) {
				line.setBorderColor(getBorderColor(dialogLine.getBorderColor()));
				CmdAdd cmdAdd = new CmdAdd(line, model);
				controller.executeCommand(cmdAdd);
			}

			clickedPoint = null;
		}
	}

	void addCircle(MouseEvent event) {
		Point center = new Point(event.getX(), event.getY());
		CircleDialog dialogCircle = new CircleDialog();
		dialogCircle.setTxtXcoordinate(Integer.toString(center.getXcoordinate()));
		dialogCircle.setTxtYcoordinate(Integer.toString(center.getYcoordinate()));
		dialogCircle.setTxtCoordinateXeditable(false);
		dialogCircle.setTxtCoordinateYeditable(false);
		dialogCircle.setVisible(true);

		if (dialogCircle.isOk()) {
			Circle circle = new Circle(center, Integer.parseInt(dialogCircle.getTxtRadius()));
			circle.setAreaColor(getAreaColor(dialogCircle.getAreaColor()));
			circle.setBorderColor(getBorderColor(dialogCircle.getBorderColor()));
			controller.executeCommand(new CmdAdd(circle, model));
		}

		clickedPoint = null;
	}

	void addRectangle(MouseEvent event) {
		Point upperLeft = new Point(event.getX(), event.getY());
		RectangleDialog rectangleDialog = new RectangleDialog();
		rectangleDialog.setTxtXcoordinate(Integer.toString(upperLeft.getXcoordinate()));
		rectangleDialog.setTxtYcoordinate(Integer.toString(upperLeft.getYcoordinate()));
		rectangleDialog.setTxtCoordinateXeditable(false);
		rectangleDialog.setTxtCoordinateYeditable(false);
		rectangleDialog.setVisible(true);

		if (rectangleDialog.isOk()) {
			int height = Integer.parseInt(rectangleDialog.getTxtHeight());
			int width = Integer.parseInt(rectangleDialog.getTxtWidth());
			Rectangle rectangle = new Rectangle(upperLeft, width, height);
			rectangle.setAreaColor(getAreaColor(rectangleDialog.getAreaColor()));
			rectangle.setBorderColor(getBorderColor(rectangleDialog.getBorderColor()));
			CmdAdd cmdAdd = new CmdAdd(rectangle, model);
			controller.executeCommand(cmdAdd);
		}

		clickedPoint = null;
	}

	void addDonut(MouseEvent event) {
		Point center = new Point(event.getX(), event.getY());
		DonutDialog donutDialog = new DonutDialog();
		donutDialog.setTxtXcoordinate(Integer.toString(center.getXcoordinate()));
		donutDialog.setTxtYcoordinate(Integer.toString(center.getYcoordinate()));
		donutDialog.setTxtCoordinateXeditable(false);
		donutDialog.setTxtCoordinateYeditable(false);
		donutDialog.setVisible(true);

		if (donutDialog.isOk()) {
			int radius = Integer.parseInt(donutDialog.getTxtRadius());
			int innerRadius = Integer.parseInt(donutDialog.getTxtInnerRadius());
			Donut donut = new Donut(center, radius, innerRadius);
			donut.setBorderColor(getBorderColor(donutDialog.getBorderColor()));
			donut.setAreaColor(getAreaColor(donutDialog.getAreaColor()));
			CmdAdd cmdAdd = new CmdAdd(donut, model);
			controller.executeCommand(cmdAdd);
		}

		clickedPoint = null;
	}

	void addHexagon(MouseEvent event) {
		Point center = new Point(event.getX(), event.getY());
		HexagonDialog dialogHexagon = new HexagonDialog();
		dialogHexagon.setTxtXcoordinate(Integer.toString(center.getXcoordinate()));
		dialogHexagon.setTxtYcoordinate(Integer.toString(center.getYcoordinate()));
		dialogHexagon.setTxtCoordinateXeditable(false);
		dialogHexagon.setTxtCoordinateYeditable(false);
		dialogHexagon.setVisible(true);

		if (dialogHexagon.isOk()) {
			int radius = Integer.parseInt(dialogHexagon.getTxtRadius());
			HexagonAdapter hexagon = new HexagonAdapter(center, radius);
			hexagon.setAreaColor(getAreaColor(dialogHexagon.getAreaColor()));
			hexagon.setBorderColor(getBorderColor(dialogHexagon.getBorderColor()));
			CmdAdd cmdAdd = new CmdAdd(hexagon, model);
			controller.executeCommand(cmdAdd);
		}

		clickedPoint = null;
	}

	private Color getBorderColor(Color color) {
		if (color != null) {
			frame.getSouthToolbar().getBtnBorderColor().setBackground(color);
			this.borderColor = color;
		}

		return borderColor;
	}

	private Color getAreaColor(Color color) {
		if (color != null) {
			frame.getSouthToolbar().getBtnAreaColor().setBackground(color);
			this.areaColor = color;
		}

		return areaColor;
	}
}