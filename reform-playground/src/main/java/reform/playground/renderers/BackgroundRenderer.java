package reform.playground.renderers;

import reform.rendering.canvas.CanvasRenderer;
import reform.stage.tooling.ToolState;

import java.awt.*;

public class BackgroundRenderer implements CanvasRenderer
{

	private final Color _colorLight;
	private final Color _colorDark;
	private final ToolState _toolState;
	private boolean _isPreview = false;

	public BackgroundRenderer(final ToolState toolState, final Color colorLight, final
	Color colorDark)
	{
		_colorLight = colorLight;
		_colorDark = colorDark;
		_toolState = toolState;
	}

	@Override
	public void render(final Graphics2D g2, final int width, final int height)
	{
		if (_isPreview || _toolState.getViewState() == ToolState.ViewState.Preview)
		{
			g2.setColor(_colorDark);

		}
		else
		{
			g2.setColor(_colorLight);
		}
		g2.fillRect(0, 0, width, height);
	}

	public void setPreview(final boolean enabled)
	{
		_isPreview = enabled;
	}

}
