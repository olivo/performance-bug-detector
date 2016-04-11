
class Summary {

    private Footprint accessFootprint;
    private Footprint traversalFootprint;
    private Footprint modificationFootprint;

    public Summary(){
	accessFootprint = new Footprint();
	traversalFootprint = new Footprint();
	modificationFootprint = new Footprint();
    }
}
