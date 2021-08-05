package fr.raphoulfifou.sethome.util.structure;

import java.util.List;

public class HomeParameter {
    public List<Parameters> parameters;

    /**
     * Used when a home is created to store its parameters
     * In the json file, contains the 'Parameters'
     * (Elements insinde '' are reffering to the class name)
     */
    public HomeParameter(List<Parameters> parameters) {
        this.parameters = parameters;
    }
}