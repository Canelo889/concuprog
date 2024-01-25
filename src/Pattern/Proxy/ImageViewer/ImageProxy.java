package Pattern.Proxy.ImageViewer;

public class ImageProxy implements Image{

    private String imageFilePath;
    private ImageHighResolution proxifiedImage;

    public ImageProxy(String imageFilePath) {
        this.imageFilePath= imageFilePath;
        System.out.println("Low resolution preview image of file " + imageFilePath + " is shown.");
    }

    @Override
    public void showImage(User user) {
        System.out.println("\n" + user.getName() + " selects preview image " + imageFilePath + " and wants to see its full resolution.");
        // create the Image Object only when the user is registered and the image is required to be shown
        if (RegistrationService.isRegistered(user)) {
            this.proxifiedImage = new ImageHighResolution(imageFilePath);
            // now call showImage on realSubject
            proxifiedImage.showImage(user);
        } else {
            System.out.println("User " + user.getName() + " is not registered and therefore cannot load full resolution of picture " + imageFilePath);
        }
    }
}
