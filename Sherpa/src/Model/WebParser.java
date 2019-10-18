/*
    THIS CLASS IS RESPONSIBLE FOR THE PARSING THE NEEDED ELEMENTS OUT OF THE
    SITEHTMLDOC FROM WEBPARSER
 */
package Model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class WebParser
{
    //---------------Attributes---------------
    private ArrayList<ExchangeRate> currentExchangeRates = new ArrayList<>();
    private ArrayList<Airports> airportList = new ArrayList<>();
    private final DecimalFormat df = new DecimalFormat("#.##");

    
    //--------------Methods---------------
    void parseWebDocument(Document siteHtmlDoc)                                 //Method that parses text from the HTML in a document object
    {
        for(Element row : siteHtmlDoc.select("div.table-responsive tr"))
        {     
            if(row.select(".text-nowrapX").text().equals(""))
            {
                continue;
            }
            else
            {     
                String currency = row.select(".text-nowrapX").text();
                String countryName = countryNameConverter(currency);
                String countryRegion = sortCountryRegion(countryName);
                String currExRate = row.select("td:nth-of-type(2)").text();
                double currExValue = Double.parseDouble(currExRate);

                currExValue = 1 / currExValue;
                
                getCurrentExchangeRates().add(new ExchangeRate(countryName, 
                    countryRegion, currency, Double.parseDouble(currExRate), 
                    currExValue));     
                
                String airportNames = countryAirportNames(countryName);
                String airportCodes = countryAirportCodes(countryName);
                
                getAirportList().add(new Airports(countryName, countryRegion,   
                    airportNames, airportCodes));
            }
        }   
    }


    /*@Override
    public void apOutputResults()                                               //Interface Method to print out each attribute in a rough fassion
    {
    for(int i = 0; i < getAirportList().size(); i++)
    {
    System.out.println("Country: " + getAirportList().get(i).getCountryName());
    System.out.println("Region: " + getAirportList().get(i).getCountryRegion());
    System.out.println("Airports: " + getAirportList().get(i).getAirportName());
    System.out.println("Airport Codes: " + getAirportList().get(i).getAirportCode());
    System.out.println();
    }
    }
    
    
    @Override
    public void erOutputResults()                                               //Interface Method to print out a formatted version of the attributes
    {
    for(int i = 0; i < getCurrentExchangeRates().size(); i++)
    {
    System.out.println("Country: " + getCurrentExchangeRates().get(i).getCountryName());
    System.out.println("Region: " + getCurrentExchangeRates().get(i).getCountryRegion());
    System.out.println("Currency: " + getCurrentExchangeRates().get(i).getCurrencyName());
    System.out.println("Exchange Rate: " + df.format(getCurrentExchangeRates().get(i).getCurrencyExchangeRate()));
    System.out.println("Exchange Value: " + df.format(getCurrentExchangeRates().get(i).getCurrencyExchangeValue()));
    System.out.println();
    }
    }*/
    
    
    
     public String countryNameConverter(String currency)                        //Method used to convert the currency name into the name of the country
    {                                                                           //I find this to be inelegant and possibly cpu intensive, would like to find a easy to scrape data on this.
        String convertedCountryName = "";
        
        if(currency.equalsIgnoreCase("Australian Dollar"))
        {
            convertedCountryName = "Australia";
        }
        else if(currency.equalsIgnoreCase("Indonesian Rupiah"))
        {
            convertedCountryName = "Indonesia";
        }
        else if(currency.equalsIgnoreCase("Korean Won"))
        {
            convertedCountryName = "Korea";
        }
        else if(currency.equalsIgnoreCase("Chilean Peso"))
        {
            convertedCountryName = "Chile";
        }
        else if(currency.equalsIgnoreCase("Hungarian Forint"))
        {
            convertedCountryName = "Hungary";
        }
        else if(currency.equalsIgnoreCase("Pakistan Rupee"))
        {
            convertedCountryName = "Pakistan";
        }
        else if(currency.equalsIgnoreCase("Japanese Yen"))
        {
            convertedCountryName = "Japan";
        }
        else if(currency.equalsIgnoreCase("Indian Rupee"))
        {
            convertedCountryName = "India";
        }
        else if(currency.equalsIgnoreCase("Russian Ruble"))
        {
            convertedCountryName = "Russia";
        }
        else if(currency.equalsIgnoreCase("Philippine Peso"))
        {
            convertedCountryName = "Philippines";
        }
        else if(currency.equalsIgnoreCase("Taiwan Dollar"))
        {
            convertedCountryName = "Taiwan";
        }
        else if(currency.equalsIgnoreCase("Thai Baht"))
        {
            convertedCountryName = "Thailand";
        }
        else if(currency.equalsIgnoreCase("Czech Koruna"))
        {
            convertedCountryName = "Czech Republic";
        }
        else if(currency.equalsIgnoreCase("Mexican Peso"))
        {
            convertedCountryName = "Mexico";
        }
        else if(currency.equalsIgnoreCase("South African Rand"))
        {
            convertedCountryName = "South Africa";
        }
        else if(currency.equalsIgnoreCase("Swedish Krona"))
        {
            convertedCountryName = "Sweden";
        }
        else if(currency.equalsIgnoreCase("Norwegian Krone"))
        {
            convertedCountryName = "Norway";
        }
        else if(currency.equalsIgnoreCase("Hong Kong Dollar"))
        {
            convertedCountryName = "Hong Kong";
        }
        else if(currency.equalsIgnoreCase("Chinese Yuan Renminbi"))
        {
            convertedCountryName = "China";
        }
        else if(currency.equalsIgnoreCase("Danish Krone"))
        {
            convertedCountryName = "Denmark";
        }
        else if(currency.equalsIgnoreCase("Turkish Lira"))
        {
            convertedCountryName = "Turkey";
        }
        else if(currency.equalsIgnoreCase("Malaysian Ringgit"))
        {
            convertedCountryName = "Malaysia";
        }
        else if(currency.equalsIgnoreCase("Brazilian Real"))
        {
            convertedCountryName = "Brazil";
        }
        else if(currency.equalsIgnoreCase("Polish Zloty"))
        {
            convertedCountryName = "Poland";
        }
        else if(currency.equalsIgnoreCase("Israeli New Shekel"))
        {
            convertedCountryName = "Isreal";
        }
        else if(currency.equalsIgnoreCase("New Zealand Dollar"))
        {
            convertedCountryName = "New Zealand";
        }
        else if(currency.equalsIgnoreCase("Singapore Dollar"))
        {
            convertedCountryName = "Singapore";
        }
        else if(currency.equalsIgnoreCase("Canadian Dollar"))
        {
            convertedCountryName = "Canada";
        }
        else if(currency.equalsIgnoreCase("US Dollar"))
        {
            convertedCountryName = "United States";
        }
        else if(currency.equalsIgnoreCase("Swiss Franc"))
        {
            convertedCountryName = "Switzerland";
        }
        else if(currency.equalsIgnoreCase("British Pound"))
        {
            convertedCountryName = "United Kingdom";
        }
        else if(currency.equalsIgnoreCase("Euro"))
        {
            convertedCountryName = "Euro";
        }
        else
        {
            convertedCountryName = "UNKNOWN";
        }
        
        return convertedCountryName;
    }
     
     
     public String sortCountryRegion(String countryName)                        //Method used to sort countries by the region of the world they inhabit
     {                                                                          //Again, I find this solution to be inelegant.
         String countryRegion = "Null";
         
        if(countryName.equalsIgnoreCase("United States") || countryName.
            equalsIgnoreCase("Canada") || countryName.equalsIgnoreCase("Mexico"))
            countryRegion = "North America";
        
        else if(countryName.equalsIgnoreCase("Chile") || countryName.equalsIgnoreCase
            ("Brazil"))
            countryRegion = "South America";
            
        else if(countryName.equalsIgnoreCase("Indonesia") || countryName.equalsIgnoreCase
            ("Korea") || countryName.equalsIgnoreCase("Japan") || countryName.
            equalsIgnoreCase("India") || countryName.equalsIgnoreCase("Philippines") 
            || countryName.equalsIgnoreCase("Taiwan") || countryName.
            equalsIgnoreCase("Thailand") || countryName.equalsIgnoreCase("Hong Kong")
            || countryName.equalsIgnoreCase("China") || countryName.equalsIgnoreCase
            ("Malaysia") || countryName.equalsIgnoreCase("New Zealand") || 
            countryName.equalsIgnoreCase("Australia") || countryName.
            equalsIgnoreCase("Singapore"))
            countryRegion = "Asia and Pacific";   
            
        else if(countryName.equalsIgnoreCase("Hungary") ||  countryName.equalsIgnoreCase
            ("Czech Republic") || countryName.equalsIgnoreCase("Sweden") || 
            countryName.equalsIgnoreCase("Norway") || countryName.equalsIgnoreCase
            ("Denmark") || countryName.equalsIgnoreCase("Poland") || countryName.
            equalsIgnoreCase("Switzerland") || countryName.equalsIgnoreCase("Euro") 
            || countryName.equalsIgnoreCase("United Kingdom"))
            countryRegion = "Europe";    
        
        else if(countryName.equalsIgnoreCase("Russia") || countryName.equalsIgnoreCase
            ("Pakistan") || countryName.equalsIgnoreCase("Turkey") || 
            countryName.equalsIgnoreCase("Isreal"))
            countryRegion = "Middle East and Central Asia"; 
        
        else if(countryName.equalsIgnoreCase("South Africa"))
            countryRegion = "Africa"; 
        
        else
            countryRegion = "UNKNOWN";
        
            return countryRegion;
     }
     

    
     
    public String countryAirportNames(String countryName)                      //Method used to call the names of the airports by the country name
     {
         String airportNames = "UNKNOWN";
         
         if(countryName.equalsIgnoreCase("Australia"))
        {
            airportNames = "Adelaide Airport, Brisbane Airport, Cairns Airport, "
                    + "Canberra Airport, Darwin International Airport, Gold Coast "
                    + "Airport, Hobart International Airport, Melbourne Airport, "
                    + "Avalon Airport, Perth Airport, Port Hedland International "
                    + "Airport, Sydney Airport, Townsville International Airport";
        }
        else if(countryName.equalsIgnoreCase("Indonesia"))
        {
            airportNames = "Hasanuddin International Airport, Sam Ratulangi "
                    + "International Airport, Lombok International Airport, Kuala "
                    + "Namu International Airport, Minangkabau International Airport"
                    + ", Sultan Mahmud Badaruddin II Airport, Sultan Syarif Qasim"
                    + " II International Airport, Samarinda International Airport, "
                    + "Achmad Yani International Airport, Juanda International "
                    + "Airport, Adisumarmo International Airport, Adisucipto "
                    + "International Airport, Soekarno Hatta International Airport"
                    + ", Halim Perdanakusuma International Airport, Ngurah Rai "
                    + "International Airport, Husein Sastranegara International "
                    + "Airport, Sultan Aji Muhammad Sulaiman Airport, Pattimura "
                    + "Airport, Tjilik Riwut Airport, Sentani Airport, Syamsudin "
                    + "Noor Airport, El Tari Airport, Mutiara Airport, Haluoleo "
                    + "Airport";
        }
        else if(countryName.equalsIgnoreCase("Korea"))
        {
            airportNames = "Gimhae International Airport, Daegu Airport, Jeju "
                    + "International Airport, Gimpo International Airport, Incheon"
                    + " International Airport, Cheongju International Airport, "
                    + "Muan International Airport, Yangyang International Airport";
        }
        else if(countryName.equalsIgnoreCase("Chile"))
        {
            airportNames = "Cerro Moreno International Airport, Mataveri International"
                    + " Airport, Carriel Sur International Airport, El Tepual "
                    + "International Airport, Presidente Carlos Ibáñez del Campo "
                    + "International Airport, Comodoro Arturo Merino Benítez "
                    + "International Airport";
        }
        else if(countryName.equalsIgnoreCase("Hungary"))
        {
            airportNames = "Budapest Ferenc Liszt International Airport, Debrecen"
                    + " International Airport, Hévíz-Balaton Airport, Győr-Pér "
                    + "International Airport, Pécs-Pogány International Airport";
        }
        else if(countryName.equalsIgnoreCase("Pakistan"))
        {
            airportNames = "Bahawalpur Airport, Bannu Airport, Chitral Airport, "
                    + "Dera Ghazi Khan International Airport, Dera Ismail Khan "
                    + "Airport, Faisalabad International Airport, Gilgit Airport,"
                    + " Gwadar International Airport, Islamabad International "
                    + "Airport, Jinnah International Airport, Kohat Airport, "
                    + "Allama Iqbal International Airport, Multan International "
                    + "Airport, Bacha Khan International Airport, Quetta "
                    + "International Airport, Shaikh Zayed International Airport,"
                    + " Saidu Sharif Airport, Sialkot International Airport, Skardu"
                    + " Airport, Turbat International Airport";
        }
        else if(countryName.equalsIgnoreCase("Japan"))
        {
            airportNames = "Akita Airport, Aomori Airport, Fukuoka Airport, Hakodate"
                    + " Airport, Kagoshima Airport, Komatsu Airport, Hiroshima "
                    + "Airport, New Kitakyushu Airport, Nagasaki Airport, Naha "
                    + "Airport, Chubu Centrair International Airport, Niigata "
                    + "Airport, Oita Airport, Okayama Airport, Kansai International"
                    + " Airport, New Chitose Airport, Sendai Airport, Shizuoka "
                    + "Airport, Haneda International Airport, Narita International"
                    + " Airport";
        }
        else if(countryName.equalsIgnoreCase("India"))
        {
            airportNames = "Akita Airport, Aomori Airport, Fukuoka Airport, Hakodate"
                    + " Airport, Kagoshima Airport, Komatsu Airport, Hiroshima "
                    + "Airport, New Kitakyushu Airport, Nagasaki Airport, Naha "
                    + "Airport, Chubu Centrair International Airport, Niigata "
                    + "Airport, Oita Airport, Okayama Airport, Kansai International"
                    + " Airport, New Chitose Airport, Sendai Airport, Shizuoka "
                    + "Airport, Haneda International Airport, Narita International"
                    + " Airport";
        }
        else if(countryName.equalsIgnoreCase("Russia"))
        {
            airportNames = "Abakan International Airport, Ugolny Airport, Anapa "
                    + "Airport, Talagi Airport, Narimanovo Airport, Barnaul Airport,"
                    + " Belgorod International Airport, Ignatyevo Airport, Bratsk"
                    + " Airport, Bryansk International Airport, Cheboksary Airport,"
                    + " Chelyabinsk Airport, Cherepovets Airport, Kadala Airport,"
                    + " Elista Airport, Irkutsk Airport, Grozny Airport, Khrabrovo"
                    + " Airport, Kazan Airport, Khabarovsk Novy Airport, Komsomolsk"
                    + "-on-Amur Airport, Pashkovsky Airport, Yemelyanovo International"
                    + " Airport, Kursk Vostochny Airport, Sokol Airport, Magnitogorsk"
                    + " International Airport, Uytash Airport, Mineralnye Vody "
                    + "Airport, Domodedovo International Airport, Sheremetyevo "
                    + "International Airport, Vnukovo Airport, Murmansk Airport, "
                    + "Nalchik Airport, Nizhnevartovsk Airport, Begishevo Airport, "
                    + "Strigino Airport, Spichenkovo Airport, Tolmachevo Airport,"
                    + " Omsk Tsentralny Airport, Orenburg Tsentralny Airport, "
                    + "Orsk Airport, Perm International Airport, Petrozavodsk "
                    + "Airport, Provideniya Bay Airport, Yelizovo Airport, Pskov "
                    + "Airport, Platov International Airport, Pulkovo Airport, "
                    + "Samara Kurumoch Airport, Saratov Tsentralny Airport, Sochi"
                    + " International Airport, Stavropol Shpakovskoye Airport, "
                    + "Surgut International Airport, Syktyvkar Airport, Bogashevo "
                    + "Airport, Roshchino International Airport, Baikal "
                    + "International Airport, Ulyanovsk Vostochny Airport, Ufa "
                    + "International Airport, Vladivostok International Airport, "
                    + "Beslan Airport, Volgograd International Airport, Voronezh"
                    + " International Airport, Yakutsk Airport, Tunoshna Airport,"
                    + " Koltsovo International Airport, Yuzhno-Sakhalinsk Airport";
        }
        else if(countryName.equalsIgnoreCase("Philippines"))
        {
            airportNames = "Bicol International Airport, Cagayan North International"
                    + " Airport, Mactan–Cebu International Airport, Clark "
                    + "International Airport, Francisco Bangoy International Airport,"
                    + " General Santos International Airport, Iloilo International"
                    + " Airport, Kalibo International Airport, Laoag International"
                    + " Airport, Ninoy Aquino International Airport, Bohol–Panglao"
                    + " International Airport, Puerto Princesa International Airport"
                    + ", Subic Bay International Airport, Zamboanga International "
                    + "Airport";
        }
         else if(countryName.equalsIgnoreCase("Taiwan"))
        {
            airportNames = "Kaohsiung International Airport, Taichung International"
                    + " Airport, Taipei Songshan Airport, Taoyuan International "
                    + "Airport";
        }
        else if(countryName.equalsIgnoreCase("Thailand"))
        {
            airportNames = "Suvarnabhumi Airport, Don Mueang International Airport,"
                    + " Chiang Mai International Airport, Mae Fah Luang International"
                    + " Airport, U-Tapao International Airport, Hat Yai International"
                    + " Airport, Krabi International Airport, Phuket International"
                    + " Airport, Surat Thani Airport, Samui Airport, Udon Thani "
                    + "International Airport";
        }
        else if(countryName.equalsIgnoreCase("Czech Republic"))
        {
            airportNames = "Brno-Tuřany Airport, Karlovy Vary Airport, Leoš "
                    + "Janáček Ostrava Airport, Prague Václav Havel Airport, "
                    + "Pardubice Airport";
        }
        else if(countryName.equalsIgnoreCase("Mexico"))
        {
            airportNames = "General Juan N. Alvarez International Airport, Lic. "
                    + "Jesús Terán Peredo International Airport, Cancun International"
                    + " Airport, Roberto Fierro Villalobos International Airport,"
                    + " Ciudad del Carmen International Airport, Cozumel "
                    + "International Airport, Federal de Bachigualato International"
                    + " Airport, General Guadalupe Victoria International Airport,"
                    + " Don Miguel Hidalgo y Costilla International Airport, "
                    + "Hermosillo International Airport, Bahías de Huatulco "
                    + "International Airport, Ixtapa-Zihuatanejo International "
                    + "Airport, Del Bajío International Airport, Loreto International"
                    + " Airport, Los Cabos International Airport, Playa de Oro "
                    + "International Airport, General Rafael Buelna International"
                    + " Airport, Manuel Crescencio Rejón International Airport, "
                    + "Mexico City International Airport, General Mariano Escobedo"
                    + " International Airport, General Francisco J. Mujica "
                    + "International Airport, Xoxocotlán International Airport, "
                    + "Hermanos Serdán International Airport, Lic. Gustavo Díaz "
                    + "Ordaz International Airport, Querétaro Intercontinental "
                    + "Airport, General Lucio Blanco International Airport, "
                    + "Plan de Guadalupe International Airport, Ponciano Arriaga "
                    + "International Airport, General Francisco Javier Mina "
                    + "International Airport, Gral. Abelardo L. Rodríguez "
                    + "International Airport, Lic. Adolfo López Mateos International"
                    + " Airport, Francisco Sarabia International Airport, Angel "
                    + "Albino Corzo International Airport, Uruapan International "
                    + "Airport, General Heriberto Jara International Airport, "
                    + "Carlos Rovirosa Pérez International Airport, General "
                    + "Leobardo C. Ruiz International Airport";
        }
        else if(countryName.equalsIgnoreCase("South Africa"))
        {
            airportNames = "Cape Town International Airport, King Shaka "
                    + "International Airport, OR Tambo International Airport, "
                    + "Kruger Mpumalanga International Airport, Lanseria "
                    + "International Airport";
        }
        else if(countryName.equalsIgnoreCase("Sweden"))
        {
            airportNames = "Gothenburg City Airport, Göteborg Landvetter Airport,"
                    + " Luleå Airport, Malmö Airport, Norrköping Airport, Åre "
                    + "Östersund Airport, Stockholm-Arlanda Airport, Stockholm-Bromma"
                    + " Airport, Stockholm-Skavsta Airport, Stockholm-Västerås "
                    + "Airport, Umeå Airport, Växjö Airport, Visby Airport";
        }
        else if(countryName.equalsIgnoreCase("Norway"))
        {
            airportNames = "Ålesund Airport, Bergen Airport, Bodø Airport, "
                    + "Haugesund Airport, Kristiansand Airport, Kjevik, Kristiansund"
                    + " Airport, Kvernberget, Oslo Airport-Gardermoen, Moss Airport,"
                    + " Sandefjord Airport, Stavanger Airport, Tromsø Airport, "
                    + "Trondheim Airport";
        }
        else if(countryName.equalsIgnoreCase("Hong Kong"))
        {
            airportNames = "Hong Kong International Airport";
        }
        else if(countryName.equalsIgnoreCase("China"))
        {
            airportNames = "Beihai Fucheng Airport, Beijing Capital International Airport, "
                    + "Beijing Nanyuan Airport, Changchun Longjia International Airport, "
                    + "Changsha Huanghua International Airport, Changzhou Benniu Airport, "
                    + "Chengdu Shuangliu International Airport, Chongqing Jiangbei "
                    + "International Airport, Dandong Langtou Airport, Dalian "
                    + "Zhoushuizi International Airport, Dunhuang Airport, Fuzhou "
                    + "Changle International Airport, Guangzhou Baiyun International"
                    + " Airport, Guilin Liangjiang International Airport, Guiyang"
                    + " Longdongbao Airport, Haikou Meilan International Airport, "
                    + "Hangzhou Xiaoshan International Airport, Harbin Taiping "
                    + "International Airport, Hefei Xinqiao International Airport, "
                    + "Huizhou Pingtan Airport, Jieyang Chaoshan International Airport, "
                    + "Jinan Yaoqiang International Airport, Kunming Changshui "
                    + "International Airport, Lanzhou Zhongchuan International "
                    + "Airport, Lhasa Gonggar Airport, Liuzhou Bailian Airport, "
                    + "Luoyang Beijiao Airport, Mianyang Nanjiao Airport, Mudanjiang "
                    + "Airport, Nanchang Changbei International Airport, Nanjing "
                    + "Lukou International Airport, Nanning Wuxu International "
                    + "Airport, Nantong Xingdong Airport, Ningbo Lishe International"
                    + " Airport, Qingdao liuting International Airport, Quanzhou "
                    + "Jinjiang International Airport, Sanya Phoenix International"
                    + " Airport, Shanghai Hongqiao International Airport, Shanghai "
                    + "Pudong International Airport, Shenyang Taoxian International"
                    + " Airport, Shenzhen Bao'an International Airport, Shijiazhuang "
                    + "Zhengding International Airport, Sunan Shuofang International"
                    + " Airport, Taiyuan Wusu International Airport, Tianjin "
                    + "Binhai International Airport, Tianshui Airport, Ürümqi Diwopu"
                    + " International Airport, Weihai International Airport, Wenzhou"
                    + " Yongqiang Airport, Wuhan Tianhe International Airport, "
                    + "Xiamen Gaoqi International Airport, Xi'an Xianyang International"
                    + " Airport, Xiangyang Airport, Xining Caojiabao Airport, "
                    + "Xichang Qingshan Airport, Xuzhou Guanyin Airport, Yancheng"
                    + " Nanyang Airport, Yanji Airport, Yantai Penglai International"
                    + " Airport, Yinchuan Hedong International Airport, Zhangjiajie"
                    + " Hehua Airport, Zhangye Ganzhou Airport, Zhengzhou Xinzheng"
                    + " International Airport, Zhoushan Putuoshan Airport, Zhuhai"
                    + " Jinwan Airport";
        }
        else if(countryName.equalsIgnoreCase("Turkey"))
        {
            airportNames = "Şakirpaşa Airport, Esenboğa International Airport, "
                    + "Antalya Airport, Milas-Bodrum Airport, Yenişehir Airport,"
                    + " Dalaman Airport, Oğuzeli Airport, Istanbul Airport, "
                    + "Sabiha Gökçen International Airport, Adnan Menderes "
                    + "Airport, Erkilet Airport, Konya Airport, Zafer Airport, "
                    + "Erhaç Airport, Kapadokya Airport, Samsun-Çarşamba Airport,"
                    + " Trabzon Airport, Zonguldak Airport";
        }
        else if(countryName.equalsIgnoreCase("Denmark"))
        {
            airportNames = "Aalborg Airport, Aarhus Airport, Billund Airport, "
                    + "Copenhagen Airport";
        }
        else if(countryName.equalsIgnoreCase("Malaysia"))
        {
            airportNames = "Sultan Azlan Shah Airport, Senai International Airport,"
                    + " Sultan Ismail Petra Airport, Kota Kinabalu International"
                    + " Airport, Kuala Lumpur International Airport, Kuching "
                    + "International Airport, Langkawi International Airport, "
                    + "Penang International Airport, Sultan Abdul Aziz Shah Airport";
        }
        else if(countryName.equalsIgnoreCase("Brazil"))
        {
            airportNames = "Santa Maria Airport, Val de Cães International Airport,"
                    + " Tancredo Neves International Airport, Boa Vista "
                    + "International Airport, Brasília International Airport, "
                    + "Viracopos International Airport, Campo Grande International"
                    + " Airport, Marechal Rondon International Airport, Afonso "
                    + "Pena International Airport, Hercílio Luz International "
                    + "Airport, Pinto Martins International Airport, Cataratas "
                    + "International Airport, Santa Genoveva Airport, Presidente"
                    + " Castro Pinto International Airport, Zumbi dos Palmares "
                    + "International Airport, Eduardo Gomes International Airport,"
                    + " Greater Natal International Airport, Senador Nilo Coelho "
                    + "Airport, Salgado Filho International Airport, Governador "
                    + "Jorge Teixeira de Oliveira International Airport, Guararapes"
                    + " International Airport, Rio Branco International Airport,"
                    + " Rio de Janeiro–Galeão International Airport, Santos Dumont"
                    + " Airport, Deputado Luís Eduardo Magalhães International "
                    + "Airport, Marechal Cunha Machado International Airport, São"
                    + " Paulo–Congonhas Airport, São Paulo–Guarulhos International"
                    + " Airport, Teresina Airport, Uberlândia Airport, Eurico de "
                    + "Aguiar Salles Airport";
        }
        else if(countryName.equalsIgnoreCase("Poland"))
        {
            airportNames = "Bydgoszcz Ignacy Jan Paderewski Airport, Gdańsk Lech"
                    + " Wałęsa Airport, Katowice International Airport, John Paul"
                    + " II International Airport Kraków-Balice, Lublin Airport, "
                    + "Łódź Władysław Reymont Airport, Poznań Ławica Airport, "
                    + "Rzeszów-Jasionka Airport, Szczecin-Goleniów \"Solidarność\""
                    + " Airport, Frédéric Chopin Airport, Modlin Airport, "
                    + "Copernicus Airport Wrocław";
        }
        else if(countryName.equalsIgnoreCase("Isreal"))
        {
            airportNames = "No known airports";
        }
        else if(countryName.equalsIgnoreCase("New Zealand"))
        {
            airportNames = "Auckland Airport, Christchurch International Airport, "
                    + "Dunedin International Airport, Queenstown Airport, "
                    + "Wellington International Airport";
        }
        else if(countryName.equalsIgnoreCase("Singapore"))
        {
            airportNames = "Singapore Changi Airport";
        }
        else if(countryName.equalsIgnoreCase("Canada"))
        {
            airportNames = "Calgary International Airport, Edmonton International"
                    + " Airport, Gander International Airport, Halifax Stanfield"
                    + " International Airport, John C. Munro Hamilton International"
                    + " Airport, London International Airport, Greater Moncton "
                    + "International Airport, Montreal-Pierre Elliott Trudeau "
                    + "International Airport, Ottawa Macdonald-Cartier International"
                    + " Airport, Quebec/Jean Lesage International Airport, "
                    + "Regina International Airport, Saskatoon John G. Diefenbaker "
                    + "International Airport, St. John's International Airport, "
                    + "Toronto Pearson International Airport, Vancouver International "
                    + "Airport, Victoria International Airport, Winnipeg James "
                    + "Armstrong Richardson International Airport";
        }
        else if(countryName.equalsIgnoreCase("United States"))
        {
            airportNames = "Akron–Canton Airport, Akron Fulton International Airport"
                    + ", Albany International Airport, Albuquerque International"
                    + " Sunport, Ted Stevens Anchorage International Airport, "
                    + "Appleton International Airport, Hartsfield-Jackson Atlanta"
                    + " International Airport, Atlantic City International Airport"
                    + ", Austin-Bergstrom International Airport, Baltimore-Washington"
                    + " International Thurgood Marshall Airport, Bangor International"
                    + " Airport, Birmingham-Shuttlesworth International Airport, "
                    + "Boise Airport, Logan International Airport, Buffalo Niagara"
                    + " International Airport, Charlotte/Douglas International "
                    + "Airport, Charleston International Airport, Chicago Midway"
                    + " International Airport, O'Hare International Airport, "
                    + "Cincinnati/Northern Kentucky International Airport, "
                    + "Cleveland Hopkins International Airport, John Glenn Columbus"
                    + " International Airport, Rickenbacker International Airport,"
                    + " Dallas/Fort Worth International Airport, Dayton International"
                    + " Airport, Denver International Airport, Des Moines "
                    + "International Airport, Detroit Metropolitan Wayne County "
                    + "Airport, Fairbanks International Airport, Fort Lauderdale"
                    + "-Hollywood International Airport, Southwest Florida "
                    + "International Airport, Fresno Yosemite International Airport"
                    + ", Bradley International Airport, Green Bay–Austin Straubel"
                    + " International Airport, Piedmont Triad International Airport"
                    + ", Hilo International Airport, Daniel K. Inouye International"
                    + " Airport, George Bush Intercontinental Airport, William P."
                    + " Hobby Airport, Huntsville International Airport, Indianapolis"
                    + " International Airport, Jacksonville International Airport,"
                    + " Juneau International Airport, Kansas City International "
                    + "Airport, Ketchikan International Airport, Key West International"
                    + " Airport, Kona International Airport, McGhee Tyson Airport,"
                    + " Lakeland Linder International Airport, Capital Region "
                    + "International Airport, McCarran International Airport, "
                    + "Clinton National Airport, Los Angeles International Airport"
                    + ", Louisville International Airport, Melbourne International"
                    + " Airport, Memphis International Airport, Miami International"
                    + " Airport, Midland International Air & Space Port, General"
                    + " Mitchell International Airport, Minneapolis-Saint Paul "
                    + "International Airport, Myrtle Beach International Airport, "
                    + "Nashville International Airport, Louis Armstrong New Orleans "
                    + "International Airport, John F. Kennedy International Airport,"
                    + " LaGuardia Airport, Newark Liberty International Airport, "
                    + "Stewart International Airport, Norfolk International Airport, "
                    + "Metropolitan Oakland International Airport, Will Rogers "
                    + "World Airport, Eppley Airfield, Ontario International Airport,"
                    + " John Wayne Airport, Orlando International Airport, Orlando"
                    + " Sanford International Airport, Palm Springs International"
                    + " Airport, Northwest Florida Beaches International Airport,"
                    + " Pensacola International Airport, Philadelphia International"
                    + " Airport, Phoenix Sky Harbor International Airport, Phoenix–Mesa"
                    + " Gateway Airport, Pittsburgh International Airport, Portland"
                    + " International Jetport, Portland International Airport, "
                    + "T.F. Green Airport, Raleigh-Durham International Airport, "
                    + "Reno-Tahoe International Airport, Richmond International "
                    + "Airport, Rochester International Airport, Greater Rochester"
                    + " International Airport, Chicago Rockford International Airport"
                    + ", Sacramento International Airport, Salt Lake City International"
                    + " Airport, San Antonio International Airport, San Bernardino "
                    + "International Airport, San Diego International Airport, "
                    + "San Francisco International Airport, San Jose International "
                    + "Airport, Sarasota-Bradenton International Airport, Savannah"
                    + "/Hilton Head International Airport, Kenmore Air Harbor "
                    + "Seaplane Base, King County International Airport, Seattle-"
                    + "Tacoma International Airport, Paine Field, Spokane "
                    + "International Airport, Lambert-Saint Louis International "
                    + "Airport, St. Petersburg-Clearwater International Airport, "
                    + "Syracuse Hancock International Airport, Tallahassee "
                    + "International Airport, Tampa International Airport, Ronald "
                    + "Reagan Washington National Airport**, Washington Dulles "
                    + "International Airport, Palm Beach International Airport, "
                    + "Wilkes-Barre/Scranton International Airport, Wilmington "
                    + "International Airport";
        }
        else if(countryName.equalsIgnoreCase("Switzerland"))
        {
            airportNames = "EuroAirport Basel–Mulhouse–Freiburg, Bern-Belp Airport"
                    + ", Geneva International Airport, St. Gallen-Altenrhein "
                    + "Airport, Zurich Airport";
        }
        else if(countryName.equalsIgnoreCase("United Kingdom"))
        {
            airportNames = "Birmingham International Airport, Bournemouth Airport"
                    + ", Bristol Airport, Cardiff Airport, Robin Hood Airport "
                    + "Doncaster Sheffield, Durham Tees Valley Airport, East "
                    + "Midlands Airport, Exeter International Airport, Leeds "
                    + "Bradford International Airport, Liverpool John Lennon "
                    + "Airport, London City Airport, Gatwick Airport, Heathrow "
                    + "Airport, Luton Airport, Southend Airport, Stansted Airport"
                    + ", Manchester Airport, Newcastle Airport, Newquay Cornwall "
                    + "Airport, Norwich International Airport, Southampton "
                    + "Airport, Aberdeen Airport, Edinburgh Airport, Glasgow "
                    + "International Airport, Glasgow Prestwick Airport, Inverness"
                    + " Airport, Belfast International Airport, George Best Belfast"
                    + " City Airport, City of Derry Airport";
        }
        else if(countryName.equalsIgnoreCase("Euro"))
        {
            airportNames = "Work in Progress";
        }
        else
            airportNames = "UNKNOWN";
         
         
         
         return airportNames;
     }
     
     
     public String countryAirportCodes(String countryName)                      //Method used to call the airport codes by the country name
     {
         String airportCodes = "Null";
         
         if(countryName.equalsIgnoreCase("Australia"))
        {
            airportCodes = "ADL, BNE, CNS, CBR, DRW, OOL, HBA, MEL, AVV, PER, "
                    + "PHE, SYD, TSV";
        }
        else if(countryName.equalsIgnoreCase("Indonesia"))
        {
            airportCodes = "UPG, MDC, LOP, KNO, PDG, PLM, PKU, SRI, SRG, SUB, "
                    + "SOC, JOG, CGK, HLP, DPS, BDO, BPN, AMQ, PKY, DJJ, BDJ, "
                    + "KOE, PLW, KDI";
        }
        else if(countryName.equalsIgnoreCase("Korea"))
        {
            airportCodes = "PUS, TAE, CJU, GMP, ICN, CJJ, MWX, YNY";
        }
        else if(countryName.equalsIgnoreCase("Chile"))
        {
            airportCodes = "ANF, IPC, CCP, PMC, PUQ, SCL";
        }
        else if(countryName.equalsIgnoreCase("Hungary"))
        {
            airportCodes = "BUD, DEB, SOB, QGY, QPJ";
        }
        else if(countryName.equalsIgnoreCase("Pakistan"))
        {
            airportCodes = "BHV, BNP, CJL, DEA, DSK, LYP, GIL, GWD, ISB, KHI, "
                    + "OHT, LHE, MUX, PEW, UET, RYK, SDT, SKT, KDU, TUK";
        }
        else if(countryName.equalsIgnoreCase("Japan"))
        {
            airportCodes = "AXT, AOJ, FUK, HKD, KOJ, KMQ, HIJ, KKJ, NGS, OKA, "
                    + "NGO, KIJ, OIT, OKJ, KIX, CTS, SDJ, FSZ, HND, NRT";
        }
        else if(countryName.equalsIgnoreCase("India"))
        {
            airportCodes = "AMD, ATQ, BLR, BHO, BBI, IXC, MAA, COK, CJB, DEL, "
                    + "DHR, GOI, MGI, GAY, GAU, HYD, IMF, IDR, JAI, CNN, CCU, "
                    + "CCJ, SIA, LKO, IXM, IXE, BOM, NAG, NMA, KPR, IXZ, PAT, "
                    + "PNQ, CRA\\NPQ, RPR, IXR, IXB, SXR, TRZ, TIR, TRV, VNS, "
                    + "VGA, VTZ, VSA";
        }
        else if(countryName.equalsIgnoreCase("Russia"))
        {
            airportCodes = "ABA, DYR, AAQ, ARH, ASF, BAX, EGO, BQS, BTK, BZK, "
                    + "CSY, CEK, CEE, HTA, ESL, IKT, GRV, KGD, KZN, KHV, KXK, "
                    + "KRR, KJA, URS, GDX, MQF, MCX, MRV, DME, SVO, VKO, MMK, "
                    + "NAL, NJC, NBC, GOJ, NOZ, OVB, OMS, REN, OSW, PEE, PES, "
                    + "PVS, PKC, PKV, ROV, LED, KUF, RTW, AER, STW, SGC, SCW, "
                    + "TOF, TJM, UUD, ULY, UFA, VVO, OGZ, VOG, VOZ, YKS, IAR, "
                    + "SVX, UUS";
        }
        else if(countryName.equalsIgnoreCase("Philippines"))
        {
            airportCodes = "N/A, N/A, CEB, CRK, DVO, GES, ILO, KLO, LAO, MNL, "
                    + "TAG, PPS, SFS, ZAM";
        }
         else if(countryName.equalsIgnoreCase("Taiwan"))
        {
            airportCodes = "KHH, RMQ, TSA, TPE";
        }
        else if(countryName.equalsIgnoreCase("Thailand"))
        {
            airportCodes = "BKK, DMK, CNX, CEI, UTP, HDY, KBV, HKT, URT, USM, UTH";
        }
        else if(countryName.equalsIgnoreCase("Czech Republic"))
        {
            airportCodes = "BRQ, KLV, OSR, PRG, PED";
        }
        else if(countryName.equalsIgnoreCase("Mexico"))
        {
            airportCodes = "ACA, AGU, CUN, CUU, CME, CZM, CUL, DGO, GDL, HMO, "
                    + "HUX, ZIH, BJX, LTO, SJD, ZLO, MZT, MID, MEX, MTY, MLM, "
                    + "OAX, PBC, PVR, QRO, REX, SLW, SLP, TAM, TIJ, TLC, TRC, "
                    + "TGZ, UPN, VER, VSA, ZCL";
        }
        else if(countryName.equalsIgnoreCase("South Africa"))
        {
            airportCodes = "CPT, DUR, JNB, MQP, HLA";
        }
        else if(countryName.equalsIgnoreCase("Sweden"))
        {
            airportCodes = "GSE, GOT, LLA, MMX, NRK, OSD, ARN, BMA, NYO, VST, "
                    + "UME, VXO, VBY";
        }
        else if(countryName.equalsIgnoreCase("Norway"))
        {
            airportCodes = "AES, BGO, BOO, HAU, KRS, KSU, OSL, RYG, TRF, SVG, "
                    + "TOS, TRD";
        }
        else if(countryName.equalsIgnoreCase("Hong Kong"))
        {
            airportCodes = "HKG";
        }
        else if(countryName.equalsIgnoreCase("China"))
        {
            airportCodes = "BHY, PEK, NAY, CGQ, CSX, CZX, CTU, CKG, DDG, DLC, "
                    + "DNH, FOC, CAN, KWL, KWE, HAK, HGH, HRB, HFE, HUZ, SWA, "
                    + "TNA, KMG, LHW, LXA, LZH, LYA, MIG, MDG, KHN, NKG, NNG, "
                    + "NTG, NGB, TAO, JJN, SYX, SHA, PVG, SHE, SZX, SJW, WUX, "
                    + "TYN, TSN, THQ, URC, WEH, WNZ, WUH, XMN, XIY, XFN, XNN, "
                    + "XIC, XUZ, YNZ, YNJ, YNT, INC, DYG, YZY, CGO, HSN, ZUH";
        }
        else if(countryName.equalsIgnoreCase("Turkey"))
        {
            airportCodes = "ADA, ESB, AYT, BJV, YEI, DLM, GZT, IST, SAW, ADB, "
                    + "ASR, KYA, KZR, MLX, NAV, SZF, TZX, ONQ";
        }
        else if(countryName.equalsIgnoreCase("Denmark"))
        {
            airportCodes = "AAL, AAR, BLL, CPH";
        }
        else if(countryName.equalsIgnoreCase("Malaysia"))
        {
            airportCodes = "IPH, JHB, KBR, BKI, KUL, KCH, LGK, PEN, SZB";
        }
        else if(countryName.equalsIgnoreCase("Brazil"))
        {
            airportCodes = "AJU, BEL, CNF, BVB, BSB, VCP, CGR, CGB, CWB, FLN, "
                    + "FOR, IGU, GYN, JPA, MCZ, MAO, NAT, PNZ, POA, PVH, REC, "
                    + "RBR, GIG, SDU, SSA, SLZ, CGH, GRU, THE, UDI, VIX";
        }
        else if(countryName.equalsIgnoreCase("Poland"))
        {
            airportCodes = "BZG, GDN, KTW, KRK, LUZ, LCJ, POZ, RZE, SZZ, WAW, "
                    + "WMI, WRO";
        }
        else if(countryName.equalsIgnoreCase("Isreal"))
        {
            airportCodes = "No Found Airports";
        }
        else if(countryName.equalsIgnoreCase("New Zealand"))
        {
            airportCodes = "AKL, CHC, DUD, ZQN, WLG";
        }
        else if(countryName.equalsIgnoreCase("Singapore"))
        {
            airportCodes = "SIN";
        }
        else if(countryName.equalsIgnoreCase("Canada"))
        {
            airportCodes = "YYC, YEG, YQX, YHZ, YHM, YXU, YQM, YUL, YOW, YQB, "
                    + "YQR, YXE, YYT, YYZ, YVR, YYJ, YWG";
        }
        else if(countryName.equalsIgnoreCase("United States"))
        {
            airportCodes = "CAK, AKC, ALB, ABQ, ANC, ATW, ATL, ACY, AUS, BWI, "
                    + "BGR, BHM, BOI, BOS, BUF, CLT, CHS, MDW, ORD, CVG, CLE, "
                    + "CMH, LCK, DFW, DAY, DEN, DSM, DTW, FAI, FLL, RSW, FAT, "
                    + "BDL, GRB, GSO, ITO, HNL, IAH, HOU, HSV, IND, JAX, JNU, "
                    + "MCI, KTN, EYW, KOA, TYS, LAL, LAN, LAS, LIT, LAX, SDF, "
                    + "MLB, MEM, MIA, MAF, MKE, MSP, MYR, BNA, MSY, JFK, LGA, "
                    + "EWR, SWF, ORF, OAK, OKC, OMA, ONT, SNA, MCO, SFB, PSP, "
                    + "ECP, PNS, PHL, PHX, AZA, PIT, PWM, PDX, PVD, RDU, RNO, "
                    + "RIC, RST, ROC, RFD, SMF, SLC, SAT, SBD, SAN, SFO, SJC, "
                    + "SRQ, SAV, LKE, BFI, SEA, PAE, GEG, STL, PIE, SYR, TLH, "
                    + "TPA, DCA, IAD, PBI, AVP, ILM";
        }
        else if(countryName.equalsIgnoreCase("Switzerland"))
        {
            airportCodes = "BSL, BRN, GVA, ACH, ZRH";
        }
        else if(countryName.equalsIgnoreCase("United Kingdom"))
        {
            airportCodes = "BHX, BOH, BRS, CWL, DSA, MME, EMA, EXT, LBA, LPL, "
                    + "LCY, LGW, LHR, LTN, SEN, STN, MAN, NCL, NQY, NWI, SOU, "
                    + "ABZ, EDI, GLA, PIK, INV, BFS, BHD, LDY";
        }
        else if(countryName.equalsIgnoreCase("Euro"))
        {
            airportCodes = "Work in progress";
        }
        else
            airportCodes = "UNKNOWN";
         
         
         return airportCodes;
     }
     
     
    
    
    //---------------Sets and Gets---------------
    public ArrayList<ExchangeRate> getCurrentExchangeRates()                    //Get method for the private currentExchangeRate object
    {
        return currentExchangeRates;
    }


    public void setCurrentExchangeRates(ArrayList<ExchangeRate>                 //Set method for the private currentExchangeRate object
            currentExchangeRates)
    {
        this.currentExchangeRates = currentExchangeRates;
    }   


    public ArrayList<Airports> getAirportList()                                 //Get methode for the private airportList object
    {
        return airportList;
    }


    public void setAirportList(ArrayList<Airports> airportList)                 //Set method for the private airportList object
    {
        this.airportList = airportList;
    }
 
}
