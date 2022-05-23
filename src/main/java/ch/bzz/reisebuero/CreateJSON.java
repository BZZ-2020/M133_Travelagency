package ch.bzz.reisebuero;

import ch.bzz.reisebuero.model.Ferienziel;
import ch.bzz.reisebuero.model.Reise;
import ch.bzz.reisebuero.model.Strecke;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.UUID;

public class CreateJSON {


    public static void main(String[] args) {

        Ferienziel[] ferienziel = {
                new Ferienziel(UUID.randomUUID().toString(), "franz", "meier", "bachweg","phillip"),
                new Ferienziel(UUID.randomUUID().toString(), "hans", "mueller", "strasse","marc")
        };
        Reise[] reise = {
                new Reise (ferienziel[0],UUID.randomUUID().toString(), new Date(), 0.5f, 6, 5),
                new Reise(ferienziel[1], UUID.randomUUID().toString(), new Date(), 4.5f, 21, 3),
        };


        Strecke[] strecken = {
                new Strecke(UUID.randomUUID().toString(),34f, reise[1]),
                new Strecke(UUID.randomUUID().toString(),65f, reise[0])
        };


        ObjectMapper om = new ObjectMapper();
        try {
            om.writeValue(Paths.get("C:/Github/M133_Reisebuero/testing/reise.json").toFile(), reise);
            om.writeValue(Paths.get("C:/Github/M133_Reisebuero/testing/ferienziel.json").toFile(), ferienziel);
            om.writeValue(Paths.get("C:/Github/M133_Reisebuero/testing/strecke.json").toFile(), strecken);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}