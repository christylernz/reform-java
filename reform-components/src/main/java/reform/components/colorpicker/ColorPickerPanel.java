package reform.components.colorpicker;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;


public class ColorPickerPanel extends JPanel {
    private final ColorModel _model;
    private final HSVColorPlane _plane;
    private final HSVColorTrack _track;
    private final JPanel _numberPanel = new JPanel();
    private final JPanel _hsvPanel = new JPanel();


    private final SpinnerModel _colorSpinnerModelRed = new SpinnerNumberModel(1,
            0, 255,
            1);
    private final SpinnerModel _colorSpinnerModelGreen = new
            SpinnerNumberModel(1,
            0, 255,
            1);
    private final SpinnerModel _colorSpinnerModelBlue = new
            SpinnerNumberModel(1,
            0, 255,
            1);
    private final SpinnerModel _colorSpinnerModelAlpha = new
            SpinnerNumberModel(1,
            0, 255,
            1);

    private final JSpinner _fieldRed = new JSpinner(_colorSpinnerModelRed);
    private final JSpinner _fieldGreen = new JSpinner(_colorSpinnerModelGreen);
    private final JSpinner _fieldBlue = new JSpinner(_colorSpinnerModelBlue);
    private final JSpinner _fieldAlpha = new JSpinner(_colorSpinnerModelAlpha);

    public ColorPickerPanel(ColorModel model) {
        _model = model;
        _plane = new HSVColorPlane(_model);
        _track = new HSVColorTrack(_model);
        setLayout(new BorderLayout());
        add(_hsvPanel, BorderLayout.CENTER);
        add(_numberPanel, BorderLayout.SOUTH);


        _plane.setPreferredSize(new Dimension(250, 250));
        _track.setPreferredSize(new Dimension(250, 25));

        _hsvPanel.setLayout(new BoxLayout(_hsvPanel, BoxLayout.Y_AXIS));
        _hsvPanel.add(_plane);
        _hsvPanel.add(_track);


        _model.addListener(this::onChangePlane);

        configureSpinner(_fieldRed);
        configureSpinner(_fieldGreen);
        configureSpinner(_fieldBlue);
        configureSpinner(_fieldAlpha);


        _numberPanel.add(new JLabel("R:"));
        _numberPanel.add(_fieldRed);
        _numberPanel.add(new JLabel("G:"));
        _numberPanel.add(_fieldGreen);
        _numberPanel.add(new JLabel("B:"));
        _numberPanel.add(_fieldBlue);
        _numberPanel.add(new JLabel("A:"));
        _numberPanel.add(_fieldAlpha);

        _fieldRed.addChangeListener(this::onChangeField);
        _fieldGreen.addChangeListener(this::onChangeField);
        _fieldBlue.addChangeListener(this::onChangeField);
        _fieldAlpha.addChangeListener(this::onChangeField);
    }

    private void configureSpinner(final JSpinner fieldRed) {
    }

    private boolean _ownChange = false;

    private void onChangeField(final ChangeEvent changeEvent) {
    if(_ownChange) return;
        double r = 1.0 * (Integer)_fieldRed.getValue() / 255;
        double g = 1.0 * (Integer)_fieldGreen.getValue() / 255;
        double b = 1.0 * (Integer)_fieldBlue.getValue() / 255;
        double a = 1.0 * (Integer)_fieldAlpha.getValue() / 255;

        _model.setRGBA(r,g,b,a);
    }

    private void onChangePlane(final ColorModel colorModel) {
        _ownChange = true;
        _fieldRed.setValue((int)(_model.getRed() * 255));
        _fieldGreen.setValue((int)(_model.getGreen() * 255));
        _fieldBlue.setValue((int)(_model.getBlue() * 255));
        _fieldAlpha.setValue((int)(_model.getAlpha() * 255));
        _ownChange = false;
    }

    public ColorModel getModel() {
        return _model;
    }
}
