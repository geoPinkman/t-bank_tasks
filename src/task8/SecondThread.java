package task8;

import java.util.concurrent.Callable;

public class SecondThread implements Callable<Double> {

    private Room room;
    private Room roomPlan;

    public SecondThread(Room room, Room roomPlan) {
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


    @Override
    public Double call() {
        Point roomMidHeightPoint, rPlanMidHeightPoint;
        System.out.println(Thread.currentThread());
        do {
            roomMidHeightPoint = Util.getCoordinatesOfMiddleLength(this.room.getLeftBottom(), this.room.getLeftTop());
            rPlanMidHeightPoint = Util.getCoordinatesOfMiddleLength(this.roomPlan.getLeftBottom(), this.roomPlan.getLeftTop());
            if (roomMidHeightPoint.getY() > rPlanMidHeightPoint.getY()) {
                room.setLeftTop(roomMidHeightPoint);
                roomPlan.setLeftTop(rPlanMidHeightPoint);
            } else if(roomMidHeightPoint.getY() < rPlanMidHeightPoint.getY()){
                room.setLeftBottom(roomMidHeightPoint);
                roomPlan.setLeftBottom(rPlanMidHeightPoint);
            }
        } while (roomMidHeightPoint.getY() != rPlanMidHeightPoint.getY());

        return Util.roundValue(roomMidHeightPoint.getY());
    }
}
