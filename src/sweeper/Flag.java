package sweeper;

class Flag {

    private Matrix flagMap;

    private int countOfCloseBoxed;

    void start (){

        flagMap = new Matrix(Box.CLOSED);

        countOfCloseBoxed = Ranges.getSize().x*Ranges.getSize().y;

    }

    Box get (Coord coord){
        return flagMap.get(coord);
    }


    void setOpenedToBox(Coord coord) {

        flagMap.set(coord, Box.OPENED);

        countOfCloseBoxed--;

    }

    void toggleFlagToBox (Coord coord){

        switch (flagMap.get(coord)){
            case FLAGED:setClosedToBox(coord); break;
            case CLOSED:setFlagToBox(coord); break;
        }
    }

    void setFlagToBox(Coord coord) {

        flagMap.set(coord, Box.FLAGED);

    }

    private void setClosedToBox(Coord coord) {

        flagMap.set(coord, Box.CLOSED);

    }

    int getCounterOfClosedBoxes() {

        return countOfCloseBoxed;
    }

     void setBombsToBox(Coord coord) {
        flagMap.set(coord, Box.BOMBED);
    }

    public void setOpenedToClosedBombBox(Coord coord) {
        if(flagMap.get(coord) == Box.CLOSED)
            flagMap.set(coord, Box.BOMBED);
    }

    public void setNoBombToFlagedSafeBomb(Coord coord) {
        if (flagMap.get(coord) == Box.FLAGED)
            flagMap.set(coord, Box.NOBOMB);
    }



     int getCountOfFlagBoxes(Coord coord) {
        int count = 0;
        for (Coord aruund : Ranges.getCoordsAround(coord))
            if (flagMap.get(aruund) == Box.FLAGED)
                count++;
        return count;
    }
}

