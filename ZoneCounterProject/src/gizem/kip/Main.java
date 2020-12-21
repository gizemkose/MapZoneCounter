package gizem.kip;

public class Main {
    /**
     * In this main part, we are creating an example of the map. We are chosing the dimensions as w:5, h:6. User can change the values from the main method.
     * Test Cases (w,h): (2,2) ,(0,0) , (2,8), (10,10),(10,20)
     * Then we are dividing map into many zones.
     * Then we are calculating the total zones of the map.
     */
    public static void main(String[] args) {
        ZoneCounterInterface zoneCounterInterface = new ZoneCounterInterfaceImpl();
        Dimension dimension = new Dimension(5, 6);
        MapInterfaceImpl mapInterface = new MapInterfaceImpl();
        mapInterface.SetSize(dimension);

        try {
            // adding example zones inside the map.
            addExampleBorders(mapInterface);

            zoneCounterInterface.Init(mapInterface);
            mapInterface.Show();
            // the true answer is given by zoneCounterInterface.Solve() method.
            System.out.println(zoneCounterInterface.Solve());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addExampleBorders(MapInterfaceImpl mapInterface) {
        for (int i = 0, j = 0; i < mapInterface.getDimension().width && j < mapInterface.getDimension().height; i++, j++) {
            mapInterface.SetBorder(i, j);
        }
        for (int i = 0, j = mapInterface.getDimension().width; i < mapInterface.getDimension().height && j > 0; i++, j--) {
            mapInterface.SetBorder(i, j);
        }
    }

}
