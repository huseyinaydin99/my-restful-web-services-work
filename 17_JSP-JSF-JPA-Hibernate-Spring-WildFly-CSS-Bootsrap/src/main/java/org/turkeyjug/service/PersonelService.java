package org.turkeyjug.service;

import java.util.List;

import org.turkeyjug.model.Meslek;
import org.turkeyjug.model.Personel;
import org.turkeyjug.model.PersonelMeslekData;
 
public interface PersonelService {
    
    public String personelEkle(Personel p);
    
    public List<Personel> personelAra();
    
    public List<Personel> personelAra(Personel p);
    
    public String personelDuzenle(Personel p);
    
    public String personelSil(Personel p);
    
    public List<Meslek> getMeslekList();
     
}