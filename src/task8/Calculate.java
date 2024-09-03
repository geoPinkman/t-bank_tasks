package task8;

import java.util.concurrent.*;

public class Calculate {

    private Room room;
    private Room roomPlan;

    public Calculate(Room room, Room roomPlan) {
        this.room = room;
        this.roomPlan = roomPlan;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoomPlan() {
        return roomPlan;
    }

    public void setRoomPlan(Room roomPlan) {
        this.roomPlan = roomPlan;
    }

    public double getXPoint() {

        Point roomMidLengthPoint, rPlanMidLengthPoint;
        do {
            roomMidLengthPoint = Util.getCoordinatesOfMiddleLength(this.room.getLeftBottom(), this.room.getRightBottom());
            rPlanMidLengthPoint = Util.getCoordinatesOfMiddleLength(this.roomPlan.getLeftBottom(), this.roomPlan.getRightBottom());
            if (roomMidLengthPoint.getX() > rPlanMidLengthPoint.getX()) {
                room.setRightBottom(roomMidLengthPoint);
                roomPlan.setRightBottom(rPlanMidLengthPoint);
            } else if(roomMidLengthPoint.getX() < rPlanMidLengthPoint.getX()) {
                room.setLeftBottom(roomMidLengthPoint);
                roomPlan.setLeftBottom(rPlanMidLengthPoint);
            }

        } while (roomMidLengthPoint.getX() != rPlanMidLengthPoint.getX());
        return Util.roundValue(roomMidLengthPoint.getX());
    }

    public Point doCalculate() throws ExecutionException, InterruptedException {
        Callable<Double> callable = new SecondThread(room, roomPlan);
        FutureTask<Double> task = new FutureTask<>(callable);
        new Thread(task).start();
        double yPoint = 0;
        while (!task.isDone()) {
            yPoint = task.get();
        }
        return new Point(getXPoint(), yPoint);
    }

}
